package com.example.demo.reader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.batch.item.ItemReader;

import com.example.demo.model.StudentDTO;

public class InMemoryStudentReader implements ItemReader<StudentDTO> {

	private int nextStudentIndex;
	private List<StudentDTO> studentData;

	public InMemoryStudentReader() {
		initialize();
	}

	private void initialize() {
		nextStudentIndex = 0;
		
		StudentDTO tony = new StudentDTO();
		tony.setEmailAddress("tony.tester@gmail.com");
		tony.setName("Tony Tester");
		tony.setPurchasedPackage("master");

		StudentDTO nick = new StudentDTO();
		nick.setEmailAddress("nick.newbie@gmail.com");
		nick.setName("Nick Newbie");
		nick.setPurchasedPackage("starter");

		StudentDTO iaan = new StudentDTO();
		iaan.setEmailAddress("iaan.intermediate@gmail.com");
		iaan.setName("Iaan Intermediate");
		iaan.setPurchasedPackage("intermediate");

		studentData = Collections.unmodifiableList(Arrays.asList(tony, nick, iaan));
	}

	@Override
	public StudentDTO read() throws Exception {
		StudentDTO nextStudent = null;

		if (nextStudentIndex < studentData.size()) {
			nextStudent = studentData.get(nextStudentIndex);
			nextStudentIndex++;
		}

		return nextStudent;
	}
	
}
