package com.usk.demo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.usk.demo.entity.User;
import com.usk.demo.exception.UserNotFoundException;
import com.usk.demo.repository.UserRepository;

@SpringBootTest
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;
	
	static User user = new User();

	@BeforeAll
	public static void setup() {
		user.setId(123L);
		user.setFirstName("fname");
		user.setLastName("lname");

	}

	@Test
	public void testGetUserByIdForSuccess() throws UserNotFoundException {

		Mockito.when(userRepository.findById(123L)).thenReturn(Optional.of(user));
		User user = userServiceImpl.getUserById(123L);
		assertNotNull(user);
		assertEquals("test", user.getFirstName());
	}

	@Test
	public void testGetUserByIdForNull() throws UserNotFoundException {

		Mockito.when(userRepository.findById(123L)).thenReturn(Optional.of(user));

		User user = userServiceImpl.getUserById(12L);
		assertNull(user);
	}

	@Test
	public void testGetUserByIdForAnyId() throws UserNotFoundException {

		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));

		User user = userServiceImpl.getUserById(876L);
		assertNotNull(user);
	}

	@Test
	@ExceptionHandler(UserNotFoundException.class)
	public void testGetUserByIdForException() throws UserNotFoundException {
		Mockito.when(userRepository.findById(123L)).thenReturn(Optional.of(user));
		User user = userServiceImpl.getUserById(876L);
		assertNotNull(user);
	}

	@AfterAll
	public static void tearDown() {
		user = null;
	}

}
