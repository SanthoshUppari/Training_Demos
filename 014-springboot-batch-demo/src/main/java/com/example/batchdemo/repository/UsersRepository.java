package com.example.batchdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.batchdemo.entity.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {
}
