package com.losolved.catalog.errorhandling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class NoSuchFlightException extends RuntimeException {
	
	
	
	public NoSuchFlightException() {
		super("Flight not found");
		
	}
	
	public NoSuchFlightException(String message) {
		super(message);
	
	}

}
