package com.testing.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.testing")
@EnableJpaRepositories(basePackages = "com.testing.Repository")
@EntityScan(basePackages = "com.testing.Entity")
public class TestingApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(TestingApplication.class, args);
	}

}
