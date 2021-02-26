package com.usk.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.usk.demo.dto.UserResponseDto;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	public void testGetCustomUser() {
		List<UserResponseDto> userResponseDtos = userRepository.getCustomUser("fname1");
		
		
	}
}
