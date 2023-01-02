package com.bejc4s2.RabbitMQ.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class MessageSource {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000,initialDelay = 500)
    public void sender(){
        String msg="Hey! Rabbit...";
        rabbitTemplate.convertAndSend(queue.getName(),msg);
        System.out.println("Message sent: "+msg);
    }
}
