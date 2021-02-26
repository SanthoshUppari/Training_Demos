package com.hcl.test.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@GetMapping(value = "/hello1")
	public String exeTest() {
		logger.debug("Entering into exeTest ==========>> ");
		String str = null;
		logger.debug("Entering into exeTest ==========>> "+str);
		int length = str.length();
		
		return "Success";
	}
	
	@GetMapping(value = "/hello2")
	public String nullTest() {
		String str = null;
		int length = str.length();
		return "Success";
	}
	
	}
