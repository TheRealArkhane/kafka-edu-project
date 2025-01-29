package com.education.kafkaconsumer.service;


import com.education.kafkadto.dto.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("united")
public class KafkaConsumerUnitedPostService {

    @KafkaListener(topics = "topic_post", groupId = "united-group")
    public void consumeUnited1(Post post) {
        log.info("United Consumer 1 consumed: {}", post);
    }

    @KafkaListener(topics = "topic_post", groupId = "united-group")
    public void consumeUnited2(Post post) {
        log.info("United Consumer 2 consumed: {}", post);
    }

    @KafkaListener(topics = "topic_post", groupId = "united-group")
    public void consumeUnited3(Post post) {
        log.info("United Consumer 3 consumed: {}", post);
    }
}
