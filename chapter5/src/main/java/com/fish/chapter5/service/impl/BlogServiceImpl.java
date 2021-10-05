package com.fish.chapter5.service.impl;

import com.fish.chapter5.domain.Blog;
import com.fish.chapter5.service.BlogService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

  @Resource(name = "masterJdbcTemplate")
  JdbcTemplate masterJdbcTemplate;

  @Resource(name = "slaveJdbcTemplate")
  JdbcTemplate slaveJdbcTemplate;

  @Override
  public List<Blog> getAllByMasterDatabase() {
    return masterJdbcTemplate.query("select * from article", new BeanPropertyRowMapper<>(Blog.class));
  }

  @Override
  public List<Blog> getAllBySlaveDatabase() {
    return slaveJdbcTemplate.query("select * from article", new BeanPropertyRowMapper<>(Blog.class));
  }

}
