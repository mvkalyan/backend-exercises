package com.sprint8.jwt.service;

import com.sprint8.jwt.domain.User;

public interface UserServiceI {
    public User addUser(User user);
    public User  loginCheck(int userId,String userPassword);

}
