package com.sprint8.jwt.rabbitmq;

import com.sprint8.jwt.domain.User;
import com.sprint8.jwt.domain.UserDTO;
import com.sprint8.jwt.service.UserServiceI;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private UserServiceI userServiceI;

    @RabbitListener(queues = "user_queue")
    public void getDtoAndAddToDataBase(UserDTO userDTO){
        User user=new User();
        user.setUserPassword(userDTO.getUserPassword());
        user.setUserEmail(userDTO.getUserEmail());
        User result=userServiceI.addUser(user);
        System.out.println(result);
    }
}
