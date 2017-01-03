package com.test.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类:
 * 
 * @author Angel --守护天使
 * @version v.0.1
 * @date 2016年9月7日
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * SpringBoot默认已经将classpath:/META-INF/resources/和classpath:/META-INF/resources/webjars/映射
	 * 所以该方法不需要重写，如果在SpringMVC中，可能需要重写定义（我没有尝试） 重写该方法需要 extends
	 * WebMvcConfigurerAdapter
	 *
	 */
	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("swagger-ui.html")
	// .addResourceLocations("classpath:/META-INF/resources/");
	//
	// registry.addResourceHandler("/webjars/**")
	// .addResourceLocations("classpath:/META-INF/resources/webjars/");
	// }

	/**
	 * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了）
	 *
	 */

	@Bean
	public Docket appApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(AppApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.test.controller.app")).paths(PathSelectors.any())
				.build();
		// Docket docket = new
		// Docket(DocumentationType.SWAGGER_2).groupName("app")
		// .genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false).forCodeGeneration(true)
		// .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
		// .select().paths(Predicates.or(PathSelectors.regex("/app/.*")))//
		// 过滤的接口
		// .build().apiInfo(testApiInfo());
		// return docket;
	}

	private ApiInfo AppApiInfo() {
		return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs")
				.description("Spring Boot中使用Swagger2构建RESTful APIs description").termsOfServiceUrl("http://test.com/")
				.licenseUrl("asdasd").contact(new Contact("", "", "miaorf@outlook.com")).version("1.0").build();
		// ApiInfo apiInfo = new ApiInfo("Test相关接口", // 大标题
		// "Test相关接口，主要用于测试.", // 小标题
		// "1.0", // 版本
		// "http://412887952-qq-com.iteye.com/", "Angel", // 作者
		// "北京知远信息科技有限公司", // 链接显示文字
		// "http://www.kfit.com.cn/"// 网站链接
		// );
		// return apiInfo;
	}

}