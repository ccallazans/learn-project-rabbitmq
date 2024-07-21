package com.ccallazans.learn_rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

//@Service
public class HelloRabbitConsumer {

    private final RabbitTemplate rabbitTemplate;

    public HelloRabbitConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "course.hello")
    public void listen(String message) {
        System.out.println("Consuming: " + message);
    }
}
