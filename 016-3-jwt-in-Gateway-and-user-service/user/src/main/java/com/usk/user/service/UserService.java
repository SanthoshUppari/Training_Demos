package com.usk.user.service;

import com.usk.user.entity.User;

public interface UserService {

	User getUserByUserName(String username);

	User findByUsername(String username);
	

}
