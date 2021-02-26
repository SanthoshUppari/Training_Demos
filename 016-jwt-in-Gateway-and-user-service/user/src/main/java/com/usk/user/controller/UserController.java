package com.usk.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.user.entity.User;
import com.usk.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/loaduserbyusername")
	public User getUserByUserName(@RequestParam String username) {
		return userService.getUserByUserName(username);
	}

	@GetMapping("/byName")
	public User findByUsername(@RequestParam String username) {
		return userService.findByUsername(username);
	}

	
}
