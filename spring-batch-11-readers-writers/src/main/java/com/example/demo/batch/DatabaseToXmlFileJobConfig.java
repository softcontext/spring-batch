package com.example.demo.batch;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.example.demo.model.StudentDTO;

@Configuration
public class DatabaseToXmlFileJobConfig {

	private static final String QUERY_FIND_STUDENTS = "SELECT email_address, name, purchased_package FROM STUDENTS ORDER BY email_address ASC";

	@Bean
	public ItemReader<StudentDTO> databaseXmlItemReader(DataSource dataSource) {
		JdbcCursorItemReader<StudentDTO> databaseReader = new JdbcCursorItemReader<>();
		databaseReader.setDataSource(dataSource);
		databaseReader.setSql(QUERY_FIND_STUDENTS);
		databaseReader.setRowMapper(new BeanPropertyRowMapper<StudentDTO>(StudentDTO.class));

		return databaseReader;
	}
	
}
