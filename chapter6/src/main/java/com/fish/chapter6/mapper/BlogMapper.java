package com.fish.chapter6.mapper;

import com.fish.chapter6.domain.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogMapper {

//  @Insert("INSERT INTO article(title, author) VALUES(#{title}, #{author})")
//  int create(Blog blog);
//
//  @Update("UPDATE article SET title=#{title},author=#{author} WHERE id=#{id}")
//  int updateById(Blog blog);
//
//  @Select("SELECT * FROM article")
//  @Results({
//    @Result(column = "id", property = "id", javaType = Integer.class),
//    @Result(property = "title", column = "title", javaType = String.class),
//    @Result(property = "author", column = "author", javaType = String.class)
//  })
//  List<Blog> getAll();
//
//  @Select("SELECT * FROM article WHERE title = #{title}")
//  @Results({
//    @Result(column = "id", property = "id", javaType = Integer.class),
//    @Result(property = "title", column = "title", javaType = String.class),
//    @Result(property = "author", column = "author", javaType = String.class)
//  })
//  List<Blog> getByTitle(String title);
//
//  @Delete("DELETE FROM article WHERE id = #{id}")
//  int deleteById(Integer id);

  int create(Blog blog);

  int updateById(Blog blog);

  List<Blog> getAll();

  List<Blog> getByTitle(@Param("title") String title);

  int deleteById(@Param("id") Integer id);
}
