package com.education.kafkaeduproject.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "topic", groupId = "customGroup")
    public void consume(String message) {
        log.info("Message received: {}", message);
    }
}
