package com.education.kafkaeduproject.kafka;

import com.education.kafkaeduproject.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonKafkaConsumer {

    @KafkaListener(topics = "topic_json", groupId = "customGroup")
    public void consume(User user) {
        log.info("JSON User received: {}", user);
    }
}
