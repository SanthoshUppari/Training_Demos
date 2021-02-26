package com.hcl.test.responsemodel;

import com.hcl.test.model.User;


public class UserResponse {
	
	private User user;
	
	private String statisMessage;
	
	private String statusCode;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatisMessage() {
		return statisMessage;
	}

	public void setStatisMessage(String statisMessage) {
		this.statisMessage = statisMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
}
