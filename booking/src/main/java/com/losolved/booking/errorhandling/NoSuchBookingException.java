package com.losolved.booking.errorhandling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NoSuchBookingException extends RuntimeException {
	
	private String message;

}
