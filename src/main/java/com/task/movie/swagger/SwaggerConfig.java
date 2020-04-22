package com.task.movie.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private static final Contact DEFAULT_CONTACT = new Contact("Ahmed Basuny", "Movie API Task", "ahmedbasuny13@gmail.com");
	private static final  ApiInfo DEFAULT_API_INFO = 
			new ApiInfo("Movie API Task", " API for movies data", "1.0", "tof", DEFAULT_CONTACT, "", "");
	
	private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<>(Arrays.asList("application/json", "application/xml") );
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_CONSUMES)
				.consumes(DEFAULT_PRODUCES_CONSUMES);
	}
}
