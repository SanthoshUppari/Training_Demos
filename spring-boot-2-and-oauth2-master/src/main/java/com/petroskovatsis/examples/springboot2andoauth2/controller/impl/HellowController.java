package com.petroskovatsis.examples.springboot2andoauth2.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HellowController {

	@GetMapping("")
	public String test() {
		return "Success";
	}
}
