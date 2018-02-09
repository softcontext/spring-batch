package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

// 수동설정을 이용하고 있다. 부트 프로젝트이므로 자동환경설정이 작동하여 충돌이 발생하거나 설정이 누락되어 제대로 작동하지 않는 것을 막기위해서 처리를 하지 않도록 설정한다.
@EnableAutoConfiguration(exclude = {
	DataSourceAutoConfiguration.class, 
	DataSourceTransactionManagerAutoConfiguration.class,
	BatchAutoConfiguration.class
})
@SpringBootApplication
@ImportResource(value= {"spring/batch/config/context.xml", "spring/batch/job/job-read-files.xml"})
public class Application implements CommandLineRunner {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");
	}
}
