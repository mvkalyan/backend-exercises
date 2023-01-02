package com.project.userauthentication.services;


import com.project.userauthentication.model.User;

public interface UserServiceI {
    public User addUser(User user);
    public User loginCheck(int userId,String userPassword);
    public int getUserIdByUserEmail(String userEmail);

    public User getUserEmailByUserId(int userId);
}
