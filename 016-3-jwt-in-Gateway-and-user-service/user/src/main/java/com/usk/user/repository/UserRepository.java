package com.usk.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usk.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username); 

}
