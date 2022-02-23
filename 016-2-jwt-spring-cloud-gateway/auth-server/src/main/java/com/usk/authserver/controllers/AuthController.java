package com.usk.authserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usk.authserver.entities.AuthRequest;
import com.usk.authserver.entities.AuthResponse;
import com.usk.authserver.services.AuthService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping(value = "/register")
	public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest authRequest) {
		return ResponseEntity.ok(authService.register(authRequest));
	}

}
