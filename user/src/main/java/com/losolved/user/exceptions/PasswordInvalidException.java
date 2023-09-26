package com.losolved.user.exceptions;

public class PasswordInvalidException extends RuntimeException {


	
	public PasswordInvalidException () {
		super("invalid password, please check if it matches the requirements"); 
		
	}
	
	
	

}
