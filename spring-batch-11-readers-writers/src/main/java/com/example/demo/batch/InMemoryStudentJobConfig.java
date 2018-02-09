package com.example.demo.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.StudentDTO;
import com.example.demo.reader.InMemoryStudentReader;

@Configuration
public class InMemoryStudentJobConfig {

	@Bean
	public ItemReader<StudentDTO> inMemoryStudentReader() {
		return new InMemoryStudentReader();
	}
	
}
