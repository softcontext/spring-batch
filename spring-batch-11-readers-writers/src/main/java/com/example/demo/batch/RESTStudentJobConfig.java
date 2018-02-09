package com.example.demo.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.StudentDTO;
import com.example.demo.reader.RESTStudentReader;

@Configuration
public class RESTStudentJobConfig {

	@Bean
	public ItemReader<StudentDTO> restStudentReader(Environment environment, RestTemplate restTemplate) {
		return new RESTStudentReader(environment.getRequiredProperty("http://localhost:3000/students"), restTemplate);
	}

}
