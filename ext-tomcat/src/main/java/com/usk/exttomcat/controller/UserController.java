package com.usk.exttomcat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/test")
	public String test() {
		return "Success";
	}
	
	@GetMapping
	public String test2() {
		return "Success";
	}
}
