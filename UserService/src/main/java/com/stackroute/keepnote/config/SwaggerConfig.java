package com.stackroute.keepnote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*As in this class we are implementing Swagger So annotate the class with @Configuration and 
 * @EnableSwagger2
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	 private static final String API_NAME     = "User Service API";
	 private static final String PACKAGE_SCAN = "com.stackroute.keepnote.controller";
	/*
	 * Annotate this method with @Bean . This method will return an Object of Docket.
	 * This method will implement logic for swagger
	 */
	@Bean
    public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(PACKAGE_SCAN))
				.paths(PathSelectors.any()).build().apiInfo(apiMetaInfo());
    }

	private ApiInfo apiMetaInfo() {
		return new ApiInfo(API_NAME, "User", "1.0", "https://stackbooks-ust.stackroute.in/",
				"Stackroute Admin", "User 1.0", "https://www.apache.org/licenses/LICENSE-2.0");
	}
	
}
