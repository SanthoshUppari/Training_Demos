package com.usk.uskgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.usk.uskgateway.config.JwtTokenUtil;
import com.usk.uskgateway.model.ApiResponse;
import com.usk.uskgateway.model.AuthToken;
import com.usk.uskgateway.model.LoginUser;
import com.usk.uskgateway.model.User;
import com.usk.uskgateway.service.impl.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {
    	System.out.println("Inside register =========>> ");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return new ApiResponse<>(200, "success",new AuthToken(token, user.getUsername()));
    }

}
