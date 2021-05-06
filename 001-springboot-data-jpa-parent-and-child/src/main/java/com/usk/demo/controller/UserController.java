package com.usk.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.demo.dto.UserResponseDto;
import com.usk.demo.entity.Address;
import com.usk.demo.entity.User;
import com.usk.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userServsice;
	
	@GetMapping("/byname")
	public List<UserResponseDto> getUsersByFirstName(@RequestParam String firstName) {
		return userServsice.getUsersByFirstName(firstName);
	}

	@GetMapping("/bynames")
	public List<User> getUsersByNames(@RequestParam String firstName, @RequestParam String lastName) {
		return userServsice.getUsersByNames(firstName, lastName);
	}

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userServsice.saveUser(user);
	}

	@GetMapping
	public List<User> getAllUsers(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return userServsice.getAllUsers(pageNumber, pageSize);
	}

	@GetMapping("/{userId}")
	public Address getUserById(@PathVariable Long userId) {
		return userServsice.getUserById(userId);
	}

	@PutMapping("/{userId}")
	public User updateuser(@PathVariable Long userId, @RequestBody User user) {
		return userServsice.updateuser(userId, user);
	}
}
