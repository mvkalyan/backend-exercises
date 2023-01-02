package com.niit.authService.service;

import com.niit.authService.model.User;
import com.niit.authService.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRespository userRespository;

    @Override
    public User addUser(User user) {
        return userRespository.save(user) ;
    }

    @Override
    public User loginCheck(int uid, String pwd) {

        if(userRespository.findById(uid).isPresent()){
            //get userobj
            User user=userRespository.findById(uid).get();
            //check password
            if(user.getPassword().equals(pwd)){
                //login success
                user.setPassword("");
                return user;
            }else{
                //login failed---id correct but pwd is wrong
                return null;
            }
        }else{
            //if user id is wrong
            //login failed
            return null;
        }
    }
}
