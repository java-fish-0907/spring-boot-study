package com.fish.chapter7.service;

import com.fish.chapter7.domain.Blog;

import java.util.List;

public interface BlogService {
  /**
   * 查询所有文章(master数据源)
   *
   * @return
   */
  List<Blog> getAllByMasterDatabase();

  /**
   * 查询所有文章(slave数据源)
   *
   * @return
   */
  List<Blog> getAllBySlaveDatabase();
}
