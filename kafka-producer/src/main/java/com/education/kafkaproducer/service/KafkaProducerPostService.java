package com.education.kafkaproducer.service;

import com.education.kafkaproducer.payload.Post;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaProducerPostService {

    private final KafkaTemplate<String, Post> kafkaTemplate;

    public void send(String topic, Post post) {
        kafkaTemplate.send(topic, post);
        log.info("Message sent to topic: " + topic + " : " + post.toString());
    }
}
