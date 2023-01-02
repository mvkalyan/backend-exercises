package com.sprint8.jwt.service;

import com.sprint8.jwt.domain.User;
import com.sprint8.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceI {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user) ;
    }

    @Override
    public User loginCheck(int uid, String pwd) {
        if(userRepository.findById(uid).isPresent()){
            User user=userRepository.findById(uid).get();
            if(user.getUserPassword().equals(pwd)){
                user.setUserPassword("");
                return user;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
}
