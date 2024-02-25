package com.losolved.catalog.errorhandling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NoSuchFlightException extends RuntimeException {
	
	private String message;

}
