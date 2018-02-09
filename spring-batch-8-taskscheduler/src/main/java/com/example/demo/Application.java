package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		
		String springConfig = "spring/batch/jobs/job-report.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
	}
}
