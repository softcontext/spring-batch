package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		
		/*
		 * Spring Boot sets java.awt.headless to true by default.
		 * Sets if the application is headless and should not instantiate AWT. 
		 * >> org.hsqldb.util.DatabaseManagerSwing 객체의 작동을 위해서 설정을 변경할 필요가 있다.
		 */
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
	    builder.headless(false).run(args);
	}

}
