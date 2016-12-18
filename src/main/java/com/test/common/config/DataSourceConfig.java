package com.test.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

	@Bean(name = "primaryDS")
	@Qualifier("primaryDS")
	@Primary
	@ConfigurationProperties(prefix = "spring.primary.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
		// DruidDataSource dataSource = new DruidDataSource();
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// dataSource.setUrl(dbUrl);
		// dataSource.setUsername(dbUser);
		// dataSource.setPassword(dbPassword);
		// return dataSource;
	}

	@Bean(name = "secondaryDS")
	@Qualifier("secondaryDS")
	@ConfigurationProperties(prefix = "spring.secondary.datasource")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}

}