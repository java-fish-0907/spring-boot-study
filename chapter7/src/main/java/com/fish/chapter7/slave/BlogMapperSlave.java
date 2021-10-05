package com.fish.chapter7.slave;

import com.fish.chapter7.domain.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogMapperSlave {

  @Select("SELECT * FROM article")
  @Results({
    @Result(column = "id", property = "id", javaType = Integer.class),
    @Result(property = "title", column = "title", javaType = String.class),
    @Result(property = "author", column = "author", javaType = String.class)
  })
  List<Blog> getAll();

}
