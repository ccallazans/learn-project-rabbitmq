package com.ccallazans.learn_rabbitmq;

import com.ccallazans.learn_rabbitmq.entity.Picture;
import com.ccallazans.learn_rabbitmq.producer.PictureProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class LearnRabbitmqApplicationProducer implements CommandLineRunner {

    private final PictureProducer pictureProducer;
    private final List<String> SOURCES = List.of("mobile", "web");
    private final List<String> TYPES = List.of("jpg", "png", "svg", "gif");

    public LearnRabbitmqApplicationProducer(PictureProducer pictureProducer) {
        this.pictureProducer = pictureProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnRabbitmqApplicationProducer.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            var p = new Picture();

            p.setName("Picture " + i);
            p.setSize(ThreadLocalRandom.current().nextLong(1, 100000));
            p.setSource(SOURCES.get(i % SOURCES.size()));
            p.setType(TYPES.get(i % TYPES.size()));

            pictureProducer.sendMessage(p);
            log.info("Send -> {}", p);
        }
    }

}
