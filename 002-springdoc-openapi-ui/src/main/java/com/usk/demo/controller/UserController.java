package com.usk.demo.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usk.demo.dto.UserRequestDto;
import com.usk.demo.dto.UserResponseDto;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/{userId}")
	public UserResponseDto getUserById(@PathParam(value = "userId") Integer userId) {
		return new UserResponseDto();
	}
	
	@PostMapping("")
	public String saveUser(@RequestBody UserRequestDto userRequestDto) {
		return "Success";
	}
}
