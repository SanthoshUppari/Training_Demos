package com.usk.authserver.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.usk.authserver.entities.AuthRequest;
import com.usk.authserver.entities.value_objects.UserVO;

@FeignClient(name = "http://USER-SERVICE/users")
public interface UserCLient {

	@PostMapping
	public UserVO save(@RequestBody AuthRequest authRequest);

}
