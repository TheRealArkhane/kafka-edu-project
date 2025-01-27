package com.education.kafkaeduproject.controller;

import com.education.kafkaeduproject.kafka.JsonKafkaProducer;
import com.education.kafkaeduproject.payload.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@AllArgsConstructor
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish/body")
    public ResponseEntity<String> publishMessage(@RequestBody User user) {
        jsonKafkaProducer.sendUser("topic_json", user);
        return ResponseEntity.ok("JSON User sent: " +  user.toString());
    }
}
