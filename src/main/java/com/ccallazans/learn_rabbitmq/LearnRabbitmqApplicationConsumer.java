package com.ccallazans.learn_rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LearnRabbitmqApplicationConsumer {

    public static void main(String[] args) {
        SpringApplication.run(LearnRabbitmqApplicationConsumer.class, args);
    }

}
