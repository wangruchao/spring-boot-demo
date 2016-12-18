package com.test.common.mybatis;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.github.pagehelper.PageHelper;

/**
 * 注册MyBatis分页插件PageHelper
 * 
 * @author Administrator
 *
 */
@MapperScan(value = "com.test.mapper.admin", sqlSessionFactoryRef = "adsSqlSessionFactory") // MyBatis启动类（我的）中添加@MapperScan注解
@Configuration
public class MyBatisAdminConfiguration {

	@Bean(name = "adsTransactionManager")
	public DataSourceTransactionManager adsTransactionManager(@Qualifier("secondaryDS") DataSource adsDataSource) {
		return new DataSourceTransactionManager(adsDataSource);
	}

	@Bean(name = "adsSqlSessionFactory")
	public SqlSessionFactory adsSqlSessionFactory(@Qualifier("secondaryDS") DataSource adsDataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(adsDataSource);
		return sessionFactory.getObject();
	}

	/**
	 * 分页
	 * 
	 * @return
	 */
	@Bean
	public PageHelper pageHelper() {
		System.out.println("MyBatisConfiguration.pageHelper()");
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		pageHelper.setProperties(p);
		return pageHelper;
	}

}