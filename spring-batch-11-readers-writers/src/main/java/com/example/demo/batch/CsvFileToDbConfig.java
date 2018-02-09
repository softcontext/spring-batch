package com.example.demo.batch;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.demo.model.StudentDTO;

@Configuration
public class CsvFileToDbConfig {
	
//	private static final String QUERY_INSERT_STUDENT = "INSERT INTO students(email_address, name, purchased_package) VALUES (?, ?, ?)";
	private static final String QUERY_INSERT_STUDENT = "INSERT INTO students(email_address, name, purchased_package) VALUES (:emailAddress, :name, :purchasedPackage)";
	
	
	@Bean
	public ItemWriter<StudentDTO> csvFileDbItemWriter(DataSource dataSource, 
			NamedParameterJdbcTemplate jdbcTemplate) {
		JdbcBatchItemWriter<StudentDTO> databaseItemWriter = new JdbcBatchItemWriter<>();
		databaseItemWriter.setDataSource(dataSource);
		databaseItemWriter.setJdbcTemplate(jdbcTemplate);
		
		// Using Indexed Parameters
//		databaseItemWriter.setSql(QUERY_INSERT_STUDENT);
//		ItemPreparedStatementSetter<StudentDTO> valueSetter = new StudentPreparedStatementSetter();
//		databaseItemWriter.setItemPreparedStatementSetter(valueSetter);
		
		// Using Named Parameters
		databaseItemWriter.setSql(QUERY_INSERT_STUDENT);
		ItemSqlParameterSourceProvider<StudentDTO> paramProvider = new BeanPropertyItemSqlParameterSourceProvider<>();
        databaseItemWriter.setItemSqlParameterSourceProvider(paramProvider);
        
		return databaseItemWriter;
	}
	
}

final class StudentPreparedStatementSetter implements ItemPreparedStatementSetter<StudentDTO> {
	 
    @Override
    public void setValues(StudentDTO student, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, student.getEmailAddress());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getPurchasedPackage());
    }
    
}