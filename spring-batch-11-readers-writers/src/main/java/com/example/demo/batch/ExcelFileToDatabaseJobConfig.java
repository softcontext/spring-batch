package com.example.demo.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.mapping.BeanWrapperRowMapper;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.batch.item.excel.support.rowset.RowSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.demo.model.StudentDTO;

@Configuration
public class ExcelFileToDatabaseJobConfig {

	@Bean
	public ItemReader<StudentDTO> excelStudentReader() {
		PoiItemReader<StudentDTO> reader = new PoiItemReader<>();
		reader.setLinesToSkip(1);
		reader.setResource(new ClassPathResource("data/students.xlsx"));
		reader.setRowMapper(excelRowMapper());
		return reader;
	}

	private RowMapper<StudentDTO> excelRowMapper() {
		/*
		 * We can map the rows of our spreadsheet into T objects 
		 * by using the BeanWrapperRowMapper<T> class as long as 
		 * our Excel spreadsheet has a header row and the column names of the header row 
		 * can be resolved into the field names of the T class.
		 */
//		BeanWrapperRowMapper<StudentDTO> rowMapper = new BeanWrapperRowMapper<>();
//		rowMapper.setTargetType(StudentDTO.class);
//		return rowMapper;
		
		return new StudentExcelRowMapper();
	}

}

/*
 * If our Excel spreadsheet doesn’t have a header row or the column names of the header row 
 * cannot resolved into the field names of the T class, 
 * we have to create a custom row mapper component that implements the RowMapper<T> interface.
 */
class StudentExcelRowMapper implements RowMapper<StudentDTO> {

	@Override
	public StudentDTO mapRow(RowSet rowSet) throws Exception {
		StudentDTO student = new StudentDTO();
		student.setName(rowSet.getColumnValue(0));
		student.setEmailAddress(rowSet.getColumnValue(1));
		student.setPurchasedPackage(rowSet.getColumnValue(2));

		return student;
	}

}