package com.abc.springboot2.mybatisplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	private final static String BASE_PACKAGE = "com.abc.springboot2.mybatisplus.controller";
	private final static String TITLE = "springboot mybatisplus";
	private final static String DESCRIPTION = "springboot mybatisplus 示例项目";
	private final static String TERMS_OF_SERVICE_URL = "http://localhost:8080";
	private final static String VERSION = "1.0";
	
	//	http://localhost:8080/swagger-ui.html

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).termsOfServiceUrl(TERMS_OF_SERVICE_URL)
				.version(VERSION).build();
	}
}
