package com.losolved.user.exceptions;

public class EmailInvalidException  extends RuntimeException{
	
	public EmailInvalidException() {
		super("Invalid email, please try again with a new one  with matches the requirements ");
	}

}
