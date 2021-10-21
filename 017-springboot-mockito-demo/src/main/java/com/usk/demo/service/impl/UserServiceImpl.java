package com.usk.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.usk.demo.dto.UserResponseDto;
import com.usk.demo.entity.User;
import com.usk.demo.exception.UserNotFoundException;
import com.usk.demo.repository.UserRepository;
import com.usk.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.ASC, "firstName").and(Sort.by(Direction.ASC, "lastName")));
		return userRepository.findAll(pageable).getContent();
	}

	@Override
	public User getUserById(Long userId) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new UserNotFoundException("User Not found");
		}
		//return null;
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {
		Pageable pageable = PageRequest.of(0, 5);
		//List<User> users = userRepository.findByFirstName(firstName);
		List<User> users = userRepository.findByFirstNameContainsOrderByFirstNameAsc(firstName, pageable);
		return users;
	}

	@Override
	public List<User> getUsersByName(String firstName, String lastName) {
		//List<User> users = userRepository.findByFirstNameAndLastName(firstName, lastName);
		List<User> users = userRepository.getUsersByName(firstName, lastName);
		
		//List<User> users = userRepository.findByFirstNameOrLastName(firstName, lastName);
		//List<User> users = userRepository.findByFirstNameContainsOrLastNameContains(firstName, lastName);
		return users;
	}
	
	@Override
	public List<UserResponseDto> getCustomUser(String firstName){
		return userRepository.getCustomUser(firstName);
	}

}
