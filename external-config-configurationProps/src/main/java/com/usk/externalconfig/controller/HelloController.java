package com.usk.externalconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usk.externalconfig.config.ConfigProps;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	ConfigProps configProps;
	
	@GetMapping
	public String test() {
		return "Hi..."+configProps.getEmailId();
	}
}
