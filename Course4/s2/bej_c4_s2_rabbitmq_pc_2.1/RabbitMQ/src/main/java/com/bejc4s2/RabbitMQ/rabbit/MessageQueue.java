package com.bejc4s2.RabbitMQ.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("myQueue")
public class MessageQueue {
    @Bean
    public Queue getQueue(){
        return new Queue("hello");
    }

    @Bean
    @Profile("source")
    public MessageSource getMessageSource(){
        return new MessageSource();
    }

    @Bean
    @Profile("destination")
    public MessageDestination getMessageDestination(){
        return new MessageDestination();
    }
}
