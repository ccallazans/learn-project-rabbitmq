package com.ccallazans.learn_rabbitmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

//@Service
@Slf4j
public class FixedProducer {

    private final RabbitTemplate rabbitTemplate;
    private int i = 0;

    public FixedProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRate = 500)
    public void sendMessage() {
        i++;
        log.info("i is: {}", i);
        rabbitTemplate.convertAndSend("course.fixedrate", "Fixed rate: " + i);
    }
}
