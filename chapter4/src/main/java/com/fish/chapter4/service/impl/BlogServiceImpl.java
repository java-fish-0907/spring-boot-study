package com.fish.chapter4.service.impl;

import com.fish.chapter4.domain.Blog;
import com.fish.chapter4.enums.ResultEnums;
import com.fish.chapter4.service.BlogService;
import com.fish.chapter4.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public Object create(Blog blog) {
    int count = jdbcTemplate.update("insert into article(title, author) values(?, ?)", blog.getTitle(), blog.getAuthor());
    if (count > 0) {
      return ResponseUtil.ok("插入成功");
    } else {
      return ResponseUtil.fail(ResultEnums.SERIOUS.getCode(), "插入失败");
    }
  }

  @Override
  public Object updateById(Blog blog) {
    int count = jdbcTemplate.update("update article set title=?,author=? where id=?", blog.getTitle(), blog.getAuthor(), blog.getId());
    if (count > 0) {
      return ResponseUtil.ok("修改成功");
    } else {
      return ResponseUtil.fail(ResultEnums.SERIOUS.getCode(), "修改失败");
    }
  }

  @Override
  public List<Blog> getAll() {
    return jdbcTemplate.query("select * from article", new BeanPropertyRowMapper<>(Blog.class));
  }


  @Override
  public List<Blog> getByTitle(String title) {
    return jdbcTemplate.query("select * from article where title = ?", (resultSet, i) -> {
      Blog blog = new Blog();
      blog.setId(resultSet.getInt("id"));
      blog.setTitle(resultSet.getString("title"));
      blog.setAuthor(resultSet.getString("author"));
      return blog;
    }, title);
  }

  @Override
  public Object deleteById(Integer id) {
    int count = jdbcTemplate.update("delete from article where id=?", id);
    if (count > 0) {
      return ResponseUtil.ok("删除成功");
    } else {
      return ResponseUtil.fail(ResultEnums.SERIOUS.getCode(), "删除失败");
    }
  }

//  @Override
//  public List<Blog> getByTitle(String title) {
//    return jdbcTemplate.query("select * from article where title = ?", new RowMapper<Blog>() {
//      @Override
//      public Blog mapRow(ResultSet resultSet, int i) throws SQLException {
//        Blog blog = new Blog();
//        blog.setId(resultSet.getInt("id"));
//        blog.setTitle(resultSet.getString("title"));
//        blog.setAuthor(resultSet.getString("author"));
//        return blog;
//      }
//    }, title);
//  }


}
