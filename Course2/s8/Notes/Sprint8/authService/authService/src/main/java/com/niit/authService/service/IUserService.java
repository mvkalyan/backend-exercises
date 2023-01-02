package com.niit.authService.service;

import com.niit.authService.model.User;

public interface IUserService {
    public User addUser(User user);
    public User  loginCheck(int uid,String pwd);

}
