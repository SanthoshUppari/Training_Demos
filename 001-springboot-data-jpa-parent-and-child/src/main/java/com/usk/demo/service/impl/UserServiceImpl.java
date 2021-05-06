package com.usk.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.usk.demo.dto.UserResponseDto;
import com.usk.demo.entity.Address;
import com.usk.demo.entity.User;
import com.usk.demo.repository.AddressRepository;
import com.usk.demo.repository.UserRepository;
import com.usk.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.ASC, "firstName").and(Sort.by(Direction.ASC, "lastName")));
		
		List<User> users = new ArrayList<>();
		List<UserResponseDto> UserResponseDtos = new ArrayList<>();
		
		for(User user :users) {
			UserResponseDto userResponseDto = new UserResponseDto(null, pageSize);
			BeanUtils.copyProperties(user, userResponseDto);
			UserResponseDtos.add(userResponseDto);
		}
		
		return userRepository.findAll(pageable).getContent();
	}

	@Override
	public Address getUserById(Long userId) {

		return addressRepository.findByUser_Id(userId);
		//userRepository.deleteById(userId);
		/*
		 * Optional<User> user = userRepository.findById(userId); if (user.isPresent())
		 * { return user.get(); }
		 */
	}

	@Override
	public User updateuser(Long userId, User user) {
		User dbUser = null;//getUserById(userId);
		userRepository.delete(dbUser);
		// dbUser.setFirstName(user.getFirstName());
		dbUser.setLastName(user.getLastName());
		dbUser.setAge(user.getAge());
		return saveUser(dbUser);
	}

	@Override
	public List<UserResponseDto> getUsersByFirstName(String firstName) {
		return userRepository.getCustomUsers(firstName);
	}

	@Override
	public List<User> getUsersByNames(String firstName, String lastName) {
		//Pageable pageable = PageRequest.of(0, 5, Sort.by(Direction.ASC, "firstName").and(Sort.by(Direction.ASC, "lastName")));
		//return userRepository.findByFirstNameContainsOrLastNameContainsOrderByFirstNameAsc(firstName, lastName, pageable);
		return userRepository.getUserByNames(firstName, lastName);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
