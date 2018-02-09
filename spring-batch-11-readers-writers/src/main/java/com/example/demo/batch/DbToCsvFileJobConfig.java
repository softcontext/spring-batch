package com.example.demo.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.example.demo.model.StudentDTO;
import com.example.demo.writer.StringHeaderWriter;

@Configuration
public class DbToCsvFileJobConfig {

	@Bean
    public ItemWriter<StudentDTO> dbCsvItemWriter() {
		String exportFileHeader = "NAME;EMAIL_ADDRESS;PACKAGE";
		StringHeaderWriter headerWriter = new StringHeaderWriter(exportFileHeader);
		
		String exportFilePath = "/tmp/students.csv";
		
		LineAggregator<StudentDTO> lineAggregator = createStudentLineAggregator();
		
        FlatFileItemWriter<StudentDTO> csvFileWriter = new FlatFileItemWriter<>();
        csvFileWriter.setHeaderCallback(headerWriter);
        csvFileWriter.setResource(new FileSystemResource(exportFilePath));
        csvFileWriter.setLineAggregator(lineAggregator);
 
        return csvFileWriter;
    }
	
	private LineAggregator<StudentDTO> createStudentLineAggregator() {
		FieldExtractor<StudentDTO> fieldExtractor = createStudentFieldExtractor();
		
        DelimitedLineAggregator<StudentDTO> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(";");
        lineAggregator.setFieldExtractor(fieldExtractor);
 
        return lineAggregator;
    }
	
	private FieldExtractor<StudentDTO> createStudentFieldExtractor() {
		BeanWrapperFieldExtractor<StudentDTO> extractor = new BeanWrapperFieldExtractor<>();
		extractor.setNames(new String[] { "name", "emailAddress", "purchasedPackage" });
		return extractor;
	}

}
