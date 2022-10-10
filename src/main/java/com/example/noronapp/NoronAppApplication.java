package com.example.noronapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class NoronAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoronAppApplication.class, args);
    }

//    @KafkaListener(topics = "first_topic", groupId = "a")
//    public void listen(String message) {
//        System.out.println("Received Messasge in group a: " + message);
//    }

}
