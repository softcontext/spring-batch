package com.example.demo.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.demo.model.StudentDTO;

@Configuration
public class DbToXmlFileJobConfig {
	
	@Bean
	ItemWriter<StudentDTO> dbXmlItemWriter() {
		String exportFilePath = "/tmp/students.xml";
		
		Jaxb2Marshaller studentMarshaller = new Jaxb2Marshaller();
		studentMarshaller.setClassesToBeBound(StudentDTO.class);
		
		StaxEventItemWriter<StudentDTO> xmlFileWriter = new StaxEventItemWriter<>();
		xmlFileWriter.setResource(new FileSystemResource(exportFilePath));
		xmlFileWriter.setRootTagName("students");
		xmlFileWriter.setMarshaller(studentMarshaller);

		return xmlFileWriter;
	}
	
}
