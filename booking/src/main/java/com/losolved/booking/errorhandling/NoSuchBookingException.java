package com.losolved.booking.errorhandling;



public class NoSuchBookingException extends RuntimeException {
	
	private String message;

	public NoSuchBookingException() {
		super("Booking not found");
	}

	public NoSuchBookingException(String message) {
		super(message);
	}
	
	

}
