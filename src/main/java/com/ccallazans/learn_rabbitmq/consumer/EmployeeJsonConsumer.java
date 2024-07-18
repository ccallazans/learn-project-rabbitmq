package com.ccallazans.learn_rabbitmq.consumer;

import com.ccallazans.learn_rabbitmq.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
@Slf4j
public class EmployeeJsonConsumer {

    private final ObjectMapper objectMapper;

    public EmployeeJsonConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "course.employee")
    public void listen(String message) throws JsonProcessingException {
        var emp = objectMapper.readValue(message, Employee.class);
        log.info("Employee is: {}", emp);
    }
}
