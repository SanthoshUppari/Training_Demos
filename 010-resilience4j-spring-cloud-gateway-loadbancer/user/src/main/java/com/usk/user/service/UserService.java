package com.usk.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.usk.user.feignclient.OrderClient;

@Service
public class UserService {

	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;

	@Autowired
	OrderClient orderClient;

	public String getInfo() {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		return circuitBreaker.run(() -> orderClient.getInfo(), throwable -> getDefaultInfo());
	}

	public String getDefaultInfo() {
		System.out.println("From fallback ======================>>");
		return "Order-service is down, Please try after some time.";
	}

}
