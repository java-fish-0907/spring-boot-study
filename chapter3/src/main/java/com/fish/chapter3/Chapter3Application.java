package com.fish.chapter3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.fish.chapter3"})
public class Chapter3Application {

  public static void main(String[] args) {
    SpringApplication.run(Chapter3Application.class, args);
  }

}
