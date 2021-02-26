package com.usk.logexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usk")
public class Uskcontroller {
	
	private static final Logger logger = LoggerFactory.getLogger(Uskcontroller.class);
	
	@GetMapping("/logs")
	public String logTest() {
		logger.trace("trace logger ========");
		logger.debug("debug logger ========");
		logger.info("info logger ========");
		logger.warn("warn logger ========");
		logger.error("error logger ========");
		
		return "Success";
	}

}
