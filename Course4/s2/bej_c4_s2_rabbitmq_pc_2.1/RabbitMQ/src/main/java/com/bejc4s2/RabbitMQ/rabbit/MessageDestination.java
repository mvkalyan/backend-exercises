package com.bejc4s2.RabbitMQ.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello")
public class MessageDestination {
    @RabbitHandler
    public void receive(String data){
        System.out.println("Received data: "+data);
    }
}
