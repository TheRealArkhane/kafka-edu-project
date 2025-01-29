package com.education.kafkaproducer.service;

import com.education.kafkaproducer.payload.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerPostService {

    private final KafkaTemplate<String, Post> kafkaTemplate;

    public void send(String topic, Post post) {
        CompletableFuture<SendResult<String, Post>> future = kafkaTemplate.send(topic, post);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Message: " + post.toString()
                        + " sent to topic: " + topic
                        + "  with offset: " + result.getRecordMetadata().offset());
            } else {
                log.info("Unable to send message: " +
                        post.toString() + " due to : " + ex.getMessage());
            }
        });
    }
}
