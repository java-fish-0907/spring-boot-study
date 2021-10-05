package com.fish.chapter7.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(
  basePackages = "com.fish.chapter7.slave",
  sqlSessionFactoryRef = "slaveSqlSessionFactory",
  sqlSessionTemplateRef = "slaveSqlSessionTemplate")
public class SlaveConfig {

  @Bean
  public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource) throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(slaveDataSource);
    return bean.getObject();
  }

  @Bean
  public SqlSessionTemplate slaveSqlSessionTemplate(@Qualifier("slaveSqlSessionFactory") SqlSessionFactory slaveSqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(slaveSqlSessionFactory);
  }

}
