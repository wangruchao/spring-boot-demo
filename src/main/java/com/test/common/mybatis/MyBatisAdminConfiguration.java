package com.test.common.mybatis;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

	// @Bean(name = "adsTransactionManager")
	// public DataSourceTransactionManager
	// adsTransactionManager(@Qualifier("secondaryDS") DataSource adsDataSource)
	// {
	// return new DataSourceTransactionManager(adsDataSource);
	// }

	@Bean(name = "adsSqlSessionFactory")
	public SqlSessionFactory adsSqlSessionFactory(@Qualifier("secondaryDS") DataSource adsDataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		// 分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		// properties.setProperty("dialect", "mysql");
		properties.setProperty("pageSizeZero", "true");
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("reasonable", "true");
		pageHelper.setProperties(properties);
		sessionFactory.setPlugins(new Interceptor[] { pageHelper });

		sessionFactory.setDataSource(adsDataSource);
		return sessionFactory.getObject();
	}

}