package com.usk.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usk.user.feignclient.OrderClient;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	OrderClient orderClient;

	@GetMapping("/test")
	public String test() {
		return "From user service";
	}
	
	@GetMapping("/port")
	public String getPort() {
		return orderClient.getInfo();
	}
}
