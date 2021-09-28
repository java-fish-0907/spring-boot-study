package com.fish.chapter2;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Blog {
    @Value("${blog.id}")
    private Long id;
    @Value("${blog.title}")
    private String title;
    @Value("${blog.author}")
    private String author;
    @Value("${blog.desc}")
    private String desc;
}
