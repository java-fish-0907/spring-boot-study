package com.fish.chapter2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "blog")
public class Blog2 {
  private Long id;
  private String title;
  private String author;
  private String desc;
}
