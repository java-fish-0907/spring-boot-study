package com.fish.chapter6.controller;

import com.fish.chapter6.domain.Blog;
import com.fish.chapter6.enums.ResultEnums;
import com.fish.chapter6.service.BlogService;
import com.fish.chapter6.util.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

  @Autowired
  public BlogService blogService;

  /**
   * 新增一篇文章
   *
   * @param blog 文章实体类
   * @return
   */
  @PostMapping(value = "/create")
  public Object create(@RequestBody Blog blog) {
    if (StringUtils.isBlank(blog.getTitle())) {
      return ResponseUtil.fail(ResultEnums.BAD_ARGUMENT_VALUE.getCode(), "请输入文章标题");
    }
    if (StringUtils.isBlank(blog.getAuthor())) {
      return ResponseUtil.fail(ResultEnums.BAD_ARGUMENT_VALUE.getCode(), "请输入文章作者");
    }
    return blogService.create(blog);
  }

  /**
   * 通过id修改文章
   *
   * @param blog
   * @return
   */
  @PostMapping(value = "/updateById")
  public Object updateById(@RequestBody Blog blog) {
    if (StringUtils.isBlank(blog.getTitle())) {
      return ResponseUtil.fail(ResultEnums.BAD_ARGUMENT_VALUE.getCode(), "请输入文章标题");
    }
    if (StringUtils.isBlank(blog.getAuthor())) {
      return ResponseUtil.fail(ResultEnums.BAD_ARGUMENT_VALUE.getCode(), "请输入文章作者");
    }
    return blogService.updateById(blog);
  }

  /**
   * 查询所有文章
   *
   * @return
   */
  @GetMapping(value = "/getAll")
  public List<Blog> getAll() {
    return blogService.getAll();
  }


  /**
   * 通过标题查询文章
   *
   * @param title
   * @return
   */
  @GetMapping(value = "/getByTitle")
  public Object getByTitle(String title) {
    if (StringUtils.isBlank(title)) {
      return ResponseUtil.fail(ResultEnums.BAD_ARGUMENT_VALUE.getCode(), "请输入文章标题");
    }
    return blogService.getByTitle(title);
  }


  /**
   * 通过ID删除文章
   *
   * @param id
   * @return
   */
  @PostMapping(value = "/deleteById")
  public Object deleteById(Integer id) {
    if (null == id || 0 == id.longValue()) {
      return ResponseUtil.fail(ResultEnums.BAD_ARGUMENT_VALUE.getCode(), "请输入文章id");
    }
    return blogService.deleteById(id);
  }
}
