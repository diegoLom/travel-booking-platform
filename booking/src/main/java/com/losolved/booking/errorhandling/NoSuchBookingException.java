package com.losolved.booking.errorhandling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class NoSuchBookingException extends RuntimeException {
	
	private String message;

	public NoSuchBookingException() {
		super("Booking not found");
	}

	public NoSuchBookingException(String message) {
		super(message);
	}
	
	

}
