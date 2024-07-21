package com.ccallazans.learn_rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

//@Service
public class HelloRabbitProducer {

    private final RabbitTemplate rabbitTemplate;

    public HelloRabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendHello(String name) {
        rabbitTemplate.convertAndSend("course.hello", "Hello " + name);
    }
}
