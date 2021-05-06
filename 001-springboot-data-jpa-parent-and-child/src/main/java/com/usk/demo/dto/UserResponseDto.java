package com.usk.demo.dto;

public class UserResponseDto {
	
	public UserResponseDto(String firstName, long count) {
		this.firstName = firstName;
		this.count = count;
	}
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private long count;
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

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
