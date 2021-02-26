package com.usk.uskgateway.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usk.uskgateway.model.User;

import feign.Param;

@FeignClient(value = "user-client", url = "localhost:8081/user/users")
public interface UserCLient {

	@GetMapping("/loaduserbyusername")
	public User getUserByUserName(@Param("username") @RequestParam	String username);

	@GetMapping("/byName")
	public User findByUsername(@Param("username") @RequestParam String username);

}
