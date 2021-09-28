package com.fish.chapter2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "custom.blog")
@PropertySource("classpath:blog.properties")
public class CustomBlog {
  private Long id;
  private String title;
  private String author;
  private String desc;
}
