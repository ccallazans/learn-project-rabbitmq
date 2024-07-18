package com.ccallazans.learn_rabbitmq.consumer;

import com.ccallazans.learn_rabbitmq.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PictureVectorConsumer {

    private final ObjectMapper objectMapper;

    public PictureVectorConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "q.picture.vector")
    public void listen(String message) throws JsonProcessingException {
        var obj = objectMapper.readValue(message, Picture.class);
        log.info("On VECTOR : {}", obj);
    }
}
