package com.losolved.booking.errorhandling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
public class NoSuchBookingException extends RuntimeException {
	
	private String message;

	public NoSuchBookingException() {
		super();
		this.message = "Booking not found";
	}

	public NoSuchBookingException(String message) {
		super();
		this.message = message;
	}
	
	

}
