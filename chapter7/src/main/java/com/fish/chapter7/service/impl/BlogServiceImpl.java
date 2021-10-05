package com.fish.chapter7.service.impl;

import com.fish.chapter7.domain.Blog;
import com.fish.chapter7.master.BlogMapperMaster;
import com.fish.chapter7.service.BlogService;
import com.fish.chapter7.slave.BlogMapperSlave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

  @Autowired
  private BlogMapperMaster blogMapperMaster;

  @Autowired
  private BlogMapperSlave blogMapperSlave;

  @Override
  public List<Blog> getAllByMasterDatabase() {
    return blogMapperMaster.getAll();
  }

  @Override
  public List<Blog> getAllBySlaveDatabase() {
    return blogMapperSlave.getAll();
  }

}
