package com.example.pharmassist.PharmassistApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class AppDoc {
	
		Info info() {
			return new Info()
					.title("Pharmassist").description("Pharmassist is a RESTfull web services "+"build Using spring boot the API covers basic methods"+"covering all CURD operation in the all entity")
							.version("v1");	
		}
		
		@Bean
		OpenAPI openAPI() {
			return new OpenAPI().info(info().contact(contact()));
			
	}
		Contact contact() {
			return new Contact()
					.email("jaganv14102002@gmail.com")
					.url("jaganvelan.github");
		}
}

