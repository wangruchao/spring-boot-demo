package com.test.common.properties;

import org.springframework.beans.factory.annotation.Value;

public class TestValueProperties {

	/**
	 * @Value 获取 properties 配置
	 */
	@Value("${test.name}")
	private String name;

}
