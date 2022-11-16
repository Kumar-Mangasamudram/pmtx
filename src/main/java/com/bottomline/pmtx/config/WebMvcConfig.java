package com.bottomline.pmtx.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**")
		.allowedOrigins("")
		.allowedMethods("GET", "POST", "PUT", "DELETE")
		.allowedHeaders("authorization")
		.allowCredentials(true);
		
	}
	
	

}
