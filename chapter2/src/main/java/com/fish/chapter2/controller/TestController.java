package com.fish.chapter2.controller;

import com.fish.chapter2.Blog;
import com.fish.chapter2.Blog2;
import com.fish.chapter2.CustomBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  private Blog blog;

  @Autowired
  private Blog2 blog2;

  @Autowired
  private CustomBlog customBlog;

  @RequestMapping("/test")
  public String test() {
    return blog.toString();
  }

  @RequestMapping("/test2")
  public String test2() {
    return blog2.toString();
  }

  @RequestMapping("/test3")
  public String test3() {
    return customBlog.toString();
  }
}
