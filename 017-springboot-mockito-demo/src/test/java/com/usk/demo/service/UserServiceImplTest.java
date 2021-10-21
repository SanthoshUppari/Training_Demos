package com.usk.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.usk.demo.entity.User;
import com.usk.demo.exception.UserNotFoundException;
import com.usk.demo.repository.UserRepository;
import com.usk.demo.service.impl.UserServiceImpl;

@ExtendWith(SpringExtension.class)
//The SpringExtension class is provided by Spring 5 and integrates the Spring TestContext 
//Framework into JUnit 5. The
//@ExtendWith annotation accepts any class that implements the Extension interface.
//In JUnit 5, the @RunWith annotation has been replaced by the more powerful @ExtendWith annotation.
class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	@Test
	void testGetUserById() {
		User user = new User();
		user.setId(1L);
		user.setFirstName("Santhosh");
		user.setLastName("U");
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
		User testUser = new User();
		try {
			testUser = userServiceImpl.getUserById(5L);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		assertNotNull(testUser);
		assertEquals("Santhosh", testUser.getFirstName());
	}
}
