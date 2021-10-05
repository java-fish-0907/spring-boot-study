package com.fish.chapter5.service;

import com.fish.chapter5.domain.Blog;

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
