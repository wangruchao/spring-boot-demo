package com.test.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
@ConditionalOnClass(Mongo.class)	// @ConditionOnClass表明该@Configuration仅仅在一定条件下才会被加载，这里的条件是Mongo.class位于类路径上
@EnableConfigurationProperties(MongoProperties.class)	//@EnableConfigurationProperties将Spring Boot的配置文件（application.properties）中的spring.data.mongodb.*属性映射为MongoProperties并注入到MongoAutoConfiguration中。
@ConditionalOnMissingBean(MongoProperties.class)	//说明Spring Boot仅仅在当前上下文中不存在Mongo对象时，才会实例化一个Bean。这个逻辑也体现了Spring Boot的另外一个特性——自定义的Bean优先于框架的默认配置，我们如果显式的在业务代码中定义了一个Mongo对象，那么Spring Boot就不再创建。
*/
@Configuration
@ConfigurationProperties(prefix = "test")  	//通过@ConfigurationProperties 读取application属性配置文件中的属性
public class TestSettings {
	
	private String id;  
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}  
}
