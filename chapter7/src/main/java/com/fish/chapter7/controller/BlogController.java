package com.fish.chapter7.controller;

import com.fish.chapter7.domain.Blog;
import com.fish.chapter7.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

  @Autowired
  public BlogService blogService;

  /**
   * 查询所有文章(master数据源)
   *
   * @return
   */
  @GetMapping(value = "/getAllByMasterDatabase")
  public List<Blog> getAllByMasterDatabase() {
    return blogService.getAllByMasterDatabase();
  }

  /**
   * 查询所有文章(slave数据源)
   *
   * @return
   */
  @GetMapping(value = "/getAllBySlaveDatabase")
  public List<Blog> getAllBySlaveDatabase() {
    return blogService.getAllBySlaveDatabase();
  }

}
