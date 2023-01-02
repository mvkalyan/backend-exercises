package com.project.pizzaapp.services;

import com.project.pizzaapp.exceptions.UserAlreadyExistException;
import com.project.pizzaapp.exceptions.UserNotFoundException;
import com.project.pizzaapp.model.CommonUser;
import com.project.pizzaapp.model.Pizza;
import com.project.pizzaapp.model.User;
import com.project.pizzaapp.model.UserDTO;
import com.project.pizzaapp.proxy.UserProxy;
import com.project.pizzaapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements UserServiceI{
    @Autowired
    private UserProxy userProxy;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) throws UserAlreadyExistException {
        if(userRepository.findById(user.getUserEmail()).isEmpty()){
            userRepository.insert(user);
            return user;
        }
        else{
            throw new UserAlreadyExistException();
        }
    }

    @Override
    public User updateUser(User userProduct, String email) throws UserNotFoundException {
        if(userRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        else{
            userRepository.save(userProduct);
            return userProduct;
        }
    }

    @Override
    public User getUserByUserEmail(String email) {
        return userRepository.findById(email).get();
    }

    @Override
    public boolean deleteUser(String email) throws UserNotFoundException {
        if(userRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        else{
            userRepository.deleteById(email);
            return true;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(CommonUser common) {
        UserDTO userDTO=new UserDTO();
        userDTO.setUserEmail(common.getEmail());
        userDTO.setUserPassword(common.getPassword());
        ResponseEntity<?> responseEntity=userProxy.sendUserAuthDetails(userDTO);
        System.out.println(responseEntity);
        User User=new User(common.getEmail(), common.getName(), common.getAddress(),new ArrayList<Pizza>());
        return userRepository.insert(User);
    }

    @Override
    public User addPizzaToUser(String email, Pizza pizza) throws UserNotFoundException {
        User user;
        if(userRepository.existsById(email)){
            user=userRepository.findById(email).get();
            user.getUserPizzaList().add(pizza);
            return userRepository.save(user);
        }
        else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public User clearUserPizza(String emailId) {
        User user=userRepository.findById(emailId).get();
        List<Pizza> pizzaList=new ArrayList<>(1);
        user.setUserPizzaList(pizzaList);
        return userRepository.save(user);
    }

    @Override
    public User deletePizzaFromUser(String emailId, int pizzaId) throws UserNotFoundException {
        boolean pizzaExist = false;
        if(userRepository.findById(emailId).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = userRepository.findById(emailId).get();
        List<Pizza> pizzas = user.getUserPizzaList();
        pizzaExist = pizzas.removeIf(x->x.getPizzaId()==pizzaId);
        if(!pizzaExist)
        {
            return null;
        }
        user.setUserPizzaList(pizzas);
        return userRepository.save(user);
    }


}
