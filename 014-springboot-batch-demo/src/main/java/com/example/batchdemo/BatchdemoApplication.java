package com.example.batchdemo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchdemoApplication.class, args);
	}

}
