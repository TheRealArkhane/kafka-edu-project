package com.education.kafkaproducer.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Post {
    private Long id;
    private String title;
    private String content;
}
