package com.usk.kafkademo.domain;

public class User {

	private String firstname;
	
	private int age;

	public User() {
	
	}

	public User(String firstname, int age) {
		this.firstname = firstname;
		this.age = age;
	}

	public String getfirstName() {
		return this.firstname;
	}

	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return "User(" + firstname + ", " + age + ")";
	}

}
