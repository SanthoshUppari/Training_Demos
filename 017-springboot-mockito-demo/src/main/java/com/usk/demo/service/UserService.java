package com.usk.demo.service;

import java.util.List;

import com.usk.demo.dto.UserResponseDto;
import com.usk.demo.entity.User;
import com.usk.demo.exception.UserNotFoundException;

public interface UserService {
	
	public void saveUser(User user);
	
	//public List<User> getAllUsers();
	
	public User getUserById(Long userId) throws UserNotFoundException;
	
	public List<User> getUsersByFirstName(String firstName);
	
	public List<User> getUsersByName(String firstName, String lastName);
	
	public List<UserResponseDto> getCustomUser(String firstName);

	public List<User> getAllUsers(int pageNumber, int pageSize);

}
