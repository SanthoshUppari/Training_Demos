package com.usk.demo.dto;

public class UserResponseDto {
	
	public UserResponseDto(String firstName, long count){
		this.firstName = firstName;
		this.count =count;
	}
	
	private String firstName;
	
	private long count;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	
	

}
