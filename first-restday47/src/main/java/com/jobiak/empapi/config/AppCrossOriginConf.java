package com.jobiak.empapi.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class AppCrossOriginConf implements WebMvcConfigurer{
	
public void addCorssMappings(CorsRegistry registry) {
	registry.addMapping("/**")
			.allowedOrigins("http://localhost:4200")
			.allowedMethods("GET");
}
}
