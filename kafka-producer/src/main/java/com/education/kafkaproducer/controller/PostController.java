package com.education.kafkaproducer.controller;


import com.education.kafkaproducer.payload.Post;
import com.education.kafkaproducer.service.KafkaProducerPostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {

    private KafkaProducerPostService kafkaProducerPostService;

    @PostMapping("/publish")
    public ResponseEntity<String> publishPost(@RequestBody Post post) {
        kafkaProducerPostService.send("topic_post", post);
        return ResponseEntity.ok("Post published: " + post.toString());
    }
}
