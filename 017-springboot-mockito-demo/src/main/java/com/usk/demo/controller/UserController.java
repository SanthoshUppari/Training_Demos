package com.usk.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.demo.dto.UserResponseDto;
import com.usk.demo.entity.User;
import com.usk.demo.exception.UserNotFoundException;
import com.usk.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("")
	public String saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return "Success";
	}
	
	@GetMapping("")
	public List<User> getAllUsers(@RequestParam int pageNumber, @RequestParam int pageSize){
		return userService.getAllUsers(pageNumber, pageSize);
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Long userId) throws UserNotFoundException {
		return userService.getUserById(userId);
	}
	
	@GetMapping("/nameSearch")
	public List<User> getUsersByFirstName(@RequestParam String firstName){
		return userService.getUsersByFirstName(firstName);
	}
	
	@GetMapping("/search")
	public List<User> getUsersByName(@RequestParam String firstName, @RequestParam String lastName){
		return userService.getUsersByName(firstName, lastName);
	}
	
	@GetMapping("/customUser")
	public List<UserResponseDto> getCustomUser(@RequestParam String firstName){
		return userService.getCustomUser(firstName);
	}

}
