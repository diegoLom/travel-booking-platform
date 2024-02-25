package com.losolved.booking.errorhandling.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BookingNoLongerAvailableException extends RuntimeException {
	
	private String message;

}
