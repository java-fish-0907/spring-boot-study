package com.fish.chapter6.service.impl;

import com.fish.chapter6.domain.Blog;
import com.fish.chapter6.enums.ResultEnums;
import com.fish.chapter6.mapper.BlogMapper;
import com.fish.chapter6.service.BlogService;
import com.fish.chapter6.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

  @Autowired
  private BlogMapper blogMapper;

  @Override
  public Object create(Blog blog) {
    int count = blogMapper.create(blog);
    if (count > 0) {
      return ResponseUtil.ok("插入成功");
    } else {
      return ResponseUtil.fail(ResultEnums.SERIOUS.getCode(), "插入失败");
    }
  }

  @Override
  public Object updateById(Blog blog) {
    int count = blogMapper.updateById(blog);
    if (count > 0) {
      return ResponseUtil.ok("修改成功");
    } else {
      return ResponseUtil.fail(ResultEnums.SERIOUS.getCode(), "修改失败");
    }
  }

  @Override
  public List<Blog> getAll() {
    return blogMapper.getAll();
  }


  @Override
  public List<Blog> getByTitle(String title) {
    return blogMapper.getByTitle(title);
  }

  @Override
  public Object deleteById(Integer id) {
    int count = blogMapper.deleteById(id);
    if (count > 0) {
      return ResponseUtil.ok("删除成功");
    } else {
      return ResponseUtil.fail(ResultEnums.SERIOUS.getCode(), "删除失败");
    }
  }

}
