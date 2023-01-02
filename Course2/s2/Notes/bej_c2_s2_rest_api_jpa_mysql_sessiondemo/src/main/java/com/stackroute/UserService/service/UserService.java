package com.stackroute.UserService.service;


import com.stackroute.UserService.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user) ;

    List<User> getAllUsers();

    User updateUser(User user, String email );

    boolean deleteUserByEmail(String email);

    List<User> getUserByLastName(String lastName);

}
