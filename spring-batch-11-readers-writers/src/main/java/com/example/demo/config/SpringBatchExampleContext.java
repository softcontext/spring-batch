package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringBatchExampleContext {
	
	/*
	 * Before we can use our new ItemReader, we have to configure the RestTemplate bean.
	 * After we have configured the RestTemplate bean, we can finally configure our new RESTStudentReader bean.
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
