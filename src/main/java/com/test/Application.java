package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@ComponentScan // 注解进行指定要扫描的包以及要扫描的类。@ComponentScan(basePackages={"com.test"})
@ServletComponentScan // 扫描相应的Servlet包
@SpringBootApplication // 很多Spring Boot开发者总是使用 @Configuration ，
						// @EnableAutoConfiguration 和 @ComponentScan
						// 注解他们的main类。由于这些注解被如此频繁地一块使用（特别是你遵循以上最佳实践时），Spring
						// Boot提供一个方便的 @SpringBootApplication 选择。该
						// @SpringBootApplication 注解等价于以默认属性使用 @Configuration ，
						// @EnableAutoConfiguration 和 @ComponentScan 。
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// public static void main(String[] args) {
	// ApplicationContext ctx = SpringApplication.run(Application.class, args);
	// // String[] beanNames = ctx.getBeanDefinitionNames();
	// // String[] beanNames = ctx.getBeanNamesForAnnotation(Service.class);
	// String[] beanNames = ctx.getBeanNamesForAnnotation(Repository.class);
	// System.out.println("所以beanNames个数：" + beanNames.length);
	// for (String bn : beanNames) {
	// System.out.println(bn);
	// }
	// }
}
