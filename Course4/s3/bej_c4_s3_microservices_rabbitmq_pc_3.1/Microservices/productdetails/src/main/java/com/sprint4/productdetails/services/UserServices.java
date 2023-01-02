package com.sprint4.productdetails.services;

import com.sprint4.productdetails.exceptions.ProductAlreadyExistException;
import com.sprint4.productdetails.exceptions.ProductNotFoundException;
import com.sprint4.productdetails.model.Common;
import com.sprint4.productdetails.model.UserDTO;
import com.sprint4.productdetails.model.UserProduct;
import com.sprint4.productdetails.rabbitmq.Producer;
import com.sprint4.productdetails.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices implements UserServicesI {
    private UserRepository userRepository;
    @Autowired
    private Producer producer;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserProduct registerUser(Common common){
        UserDTO userDTO=new UserDTO(common.getPassword(), common.getEmail());
        producer.sendDtoToQueue(userDTO);

        UserProduct userProduct=new UserProduct(common.getEmail(), common.getName(), common.getAddress(), new ArrayList<>());
        return userRepository.insert(userProduct);
    }

    @Override
    public UserProduct saveUser(UserProduct userProduct) throws ProductAlreadyExistException {
        if(userRepository.findById(userProduct.getUserEmail()).isEmpty()){
            userRepository.insert(userProduct);
            return userProduct;
        }
        else{
            throw new ProductAlreadyExistException();
        }
    }

    @Override
    public UserProduct updateUser(UserProduct userProduct, String email) throws ProductNotFoundException {
        if(userRepository.findById(email).isEmpty()){
            throw new ProductNotFoundException();
        }
        else{
            userRepository.save(userProduct);
            return userProduct;
        }
    }

    @Override
    public UserProduct getUserByUserEmail(String email) {
        return userRepository.findById(email).get();
    }

    @Override
    public boolean deleteUser(String email) throws ProductNotFoundException {
        if(userRepository.findById(email).isEmpty()){
            throw new ProductNotFoundException();
        }
        else{
            userRepository.deleteById(email);
            return true;
        }
    }

    @Override
    public List<UserProduct> getAllUsers() {
        return userRepository.findAll();
    }

}
