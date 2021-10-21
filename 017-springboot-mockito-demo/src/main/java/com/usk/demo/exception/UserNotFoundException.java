package com.usk.demo.exception;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * UserNotFoundException(){ super(); }
	 */
	
	public UserNotFoundException(String message){
		super(message);
	}

}
