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
  basePackages = "com.fish.chapter7.master",
  sqlSessionFactoryRef = "masterSqlSessionFactory",
  sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterConfig {

  @Bean
  public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(masterDataSource);
    return bean.getObject();
  }

  @Bean
  public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory masterSqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(masterSqlSessionFactory);
  }

}
