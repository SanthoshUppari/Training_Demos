package com.usk.demo.dto;

import javax.validation.constraints.NotNull;

public class UserResponseDto {

	@NotNull(message = "UserId should not be null.")
	private Long userId;
	
	private String firstName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
