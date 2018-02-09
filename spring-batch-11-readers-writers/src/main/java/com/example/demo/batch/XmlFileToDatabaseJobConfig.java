package com.example.demo.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.demo.model.StudentDTO;

@Configuration
public class XmlFileToDatabaseJobConfig {

	@Bean
	public ItemReader<StudentDTO> xmlFileItemReader() {
		Jaxb2Marshaller studentMarshaller = new Jaxb2Marshaller();
		studentMarshaller.setClassesToBeBound(StudentDTO.class);
		
		StaxEventItemReader<StudentDTO> xmlFileReader = new StaxEventItemReader<>();
		xmlFileReader.setResource(new ClassPathResource("data/students.xml"));
		xmlFileReader.setFragmentRootElementName("student");
		xmlFileReader.setUnmarshaller(studentMarshaller);

		return xmlFileReader;
	}
	
}
