package com.usk.demo.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.demo.dto.UserRequestDto;
import com.usk.demo.dto.UserResponseDto;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@Valid @RequestBody UserRequestDto userRequestDto) {
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@GetMapping("/getuser")
	public UserRequestDto getUserById(@RequestParam @NotEmpty @Size(min = 3, max = 12, message = "minmum length 3 and max 12")  String firstName) {
		return new UserRequestDto();
	}

	@GetMapping("/{userId}")
	public UserRequestDto getUser(@PathVariable("userId") @Min(3) @Max(6) String userId) {
		return new UserRequestDto();
	}
	
	@PostMapping("/newUser")
	@Valid
	public UserResponseDto saveNewUser(@Valid @RequestBody UserRequestDto userRequestDto) {
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setFirstName("fname1");
		return userResponseDto;
	}
}
