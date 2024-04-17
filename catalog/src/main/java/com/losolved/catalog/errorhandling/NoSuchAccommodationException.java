package com.losolved.catalog.errorhandling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class NoSuchAccommodationException extends RuntimeException {
	
	public NoSuchAccommodationException() {
		super("Accommodation not found");
		
	}
	
	public NoSuchAccommodationException(String message) {
		super(message);
	
	}
}
