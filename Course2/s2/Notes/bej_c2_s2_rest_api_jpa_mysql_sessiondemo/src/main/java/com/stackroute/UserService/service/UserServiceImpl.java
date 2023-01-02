package com.stackroute.UserService.service;

import com.stackroute.UserService.repository.UserRepository;
import com.stackroute.UserService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user)  {

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String email) {
        if(userRepository.findById(email).isEmpty())
        {
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUserByEmail(String email) {
        userRepository.deleteById(email);
        return true;
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName);

    }


}
