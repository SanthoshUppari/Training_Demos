package com.usk.demo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.usk.demo.entity.User;
import com.usk.demo.exception.UserNotFoundException;

@SpringBootTest
public class UserServiceImplTest2 {
	
	@Autowired
	UserServiceImpl userServiceImpl;

	@Test
	public void testGetUserByIdForSuccess() throws UserNotFoundException {

		User user = userServiceImpl.getUserById(5L);
		assertNotNull(user);
		assertEquals("test", user.getFirstName());
		System.out.println(user.getFirstName());
		//assertEquals("test", user.getFirstName());
	}

}
