package com.usk.demo.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.usk.demo.entity.User;
import com.usk.demo.service.UserService;

@SpringBootTest
public class UserControllerTest {
	
	/*
	 * @InjectMocks UserController userController;
	 * 
	 * @Mock UserService userService;
	 * 
	 * public void testGetUserById() { User user = userController.getUserById(123L);
	 * 
	 * }
	 */
	
	MockMvc mockMvc;
	
	public void testGetUserById() {
		//User user = (User) mockMvc.perform(MockMvcRequestBuilders.get("/users/{userID}"));
	}

}
