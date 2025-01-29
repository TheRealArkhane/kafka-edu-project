package com.education.kafkaconsumer.service;

import com.education.kafkaproducer.payload.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("single")
public class KafkaConsumerPostService {

    @KafkaListener(topics = "topic_post", groupId = "single-group-1")
    public void consumeSingle1(Post post) {
        log.info("Single Consumer 1 consumed: {}", post);
    }

    @KafkaListener(topics = "topic_post", groupId = "single-group-2")
    public void consumeSingle2(Post post) {
        log.info("Single Consumer 2 consumed: {}", post);
    }

    @KafkaListener(topics = "topic_post", groupId = "single-group-3")
    public void consumeSingle3(Post post) {
        log.info("Single Consumer 3 consumed: {}", post);
    }
}
