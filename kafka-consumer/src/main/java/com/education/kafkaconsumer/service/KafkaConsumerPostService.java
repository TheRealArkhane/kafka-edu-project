package com.education.kafkaconsumer.service;
import com.education.kafkaproducer.payload.Post;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaConsumerPostService {

    @KafkaListener(topics = "topic_post")
    public void consume(Post post) {
        log.info("Message consumed {}", post);
    }
}
