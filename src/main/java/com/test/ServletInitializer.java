package com.test;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootDemoApplication.class);
	}

	@Configuration
	public class GlobalDataConfiguration {
		@Bean(name = "primaryDataSource")
		@Primary
		@ConfigurationProperties(prefix = "datasource.primary")
		public DataSource primaryDataSource() {
			System.out.println("-------------------- primaryDataSource init ---------------------");
			return DataSourceBuilder.create().build();
		}

		@Bean(name = "secondaryDataSource")
		@ConfigurationProperties(prefix = "datasource.secondary")
		public DataSource secondaryDataSource() {
			System.out.println("-------------------- secondaryDataSource init ---------------------");
			return DataSourceBuilder.create().build();
		}
	}
}
