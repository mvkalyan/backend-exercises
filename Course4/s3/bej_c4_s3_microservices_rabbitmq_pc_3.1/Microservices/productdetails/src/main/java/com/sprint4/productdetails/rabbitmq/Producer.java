package com.sprint4.productdetails.rabbitmq;

import com.sprint4.productdetails.model.UserDTO;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Autowired
    public DirectExchange directExchange;

    public void sendDtoToQueue(UserDTO userDTO){
        rabbitTemplate.convertAndSend(directExchange.getName(),"user_routing",userDTO);
    }
}
