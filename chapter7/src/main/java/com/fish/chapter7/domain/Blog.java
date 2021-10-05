package com.fish.chapter7.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Blog {
  private Integer id;
  private String title;
  private String author;
}
