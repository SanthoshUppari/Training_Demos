package com.usk.externalconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.usk.externalconfig.config.ConfigProps;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProps.class)
public class ExternalConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalConfigApplication.class, args);
	}

}
