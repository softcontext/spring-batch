package com.example.demo.batch;

import javax.annotation.PostConstruct;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HSQLDBConfig {
	
	@PostConstruct
	public void getDbManager() {
		// Swing으로 만든 HSQLDB 매니저를 기동시킨다.
		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}
	
}
