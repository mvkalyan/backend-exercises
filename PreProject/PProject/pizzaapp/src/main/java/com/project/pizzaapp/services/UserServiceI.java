package com.project.pizzaapp.services;

import com.project.pizzaapp.exceptions.UserAlreadyExistException;
import com.project.pizzaapp.exceptions.UserNotFoundException;
import com.project.pizzaapp.model.CommonUser;
import com.project.pizzaapp.model.Pizza;
import com.project.pizzaapp.model.User;

import java.util.List;

public interface UserServiceI {
    public User saveUser(User user) throws UserAlreadyExistException;
    public User updateUser(User user,String email) throws UserNotFoundException;
    public User getUserByUserEmail(String email);
    public boolean deleteUser(String email) throws UserNotFoundException;
    public List<User> getAllUsers();
    public User registerUser(CommonUser common);
    public User addPizzaToUser(String email, Pizza pizza) throws UserNotFoundException;
    public User clearUserPizza(String emailId);
    public User deletePizzaFromUser(String emailId,int pizzaId) throws UserNotFoundException;
}
