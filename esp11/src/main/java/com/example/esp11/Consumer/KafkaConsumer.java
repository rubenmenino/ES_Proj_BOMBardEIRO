package com.example.esp11.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "esp11_hr", groupId = "group_id")
    public void consume(String message){
        System.out.println("message = " + message);
    }




}
