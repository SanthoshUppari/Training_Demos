package com.usk.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class Ordercontroller {
	
	@Autowired
	Environment environment;
	
	@GetMapping("/port")
	public String getInfo() {
		String port = environment.getProperty("local.server.port");
		return "From server "+port;
	}

	@GetMapping("/test")
	public String test() {
		return "from order service";
	}
}
