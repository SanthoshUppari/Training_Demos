package com.usk.uskgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.usk.uskgateway.model.User;
import com.usk.uskgateway.model.UserDto;
import com.usk.uskgateway.service.impl.UserServiceImpl;

@RestController
public class RegistrationController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public User signup(@RequestBody UserDto user) {
		return userService.save(user);
	}

}
