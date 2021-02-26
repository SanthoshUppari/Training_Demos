package com.usk.uskgateway.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.usk.uskgateway.feignclient.UserCLient;
import com.usk.uskgateway.model.User;
import com.usk.uskgateway.model.UserDto;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Autowired
	private UserCLient userCLient;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username =====>> "+username);
		User user = userCLient.getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority());
	}
	
	public User findOne(String username) {
		return userCLient.findByUsername(username);
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setAge(user.getAge());
		newUser.setSalary(user.getSalary());
		return /* userDao.save(newUser) */null;
	}
}
