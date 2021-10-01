package com.fish.chapter6.service;

import com.fish.chapter6.domain.Blog;

import java.util.List;

public interface BlogService {
  /**
   * 新增一篇文章
   * @param blog  文章实体类
   * @return
   */
  Object create(Blog blog);

  /**
   * 通过id修改文章
   * @param blog
   * @return
   */
  Object updateById(Blog blog);

  /**
   * 查询所有文章
   * @return
   */
  List<Blog> getAll();


  /**
   * 通过标题查询文章
   * @param title
   * @return
   */
  List<Blog> getByTitle(String title);


  /**
   * 通过ID删除文章
   * @param id
   * @return
   */
  Object deleteById(Integer id);
}
