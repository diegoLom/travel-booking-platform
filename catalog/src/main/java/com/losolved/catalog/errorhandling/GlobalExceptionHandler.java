package com.losolved.catalog.errorhandling;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.losolved.catalog.dto.ResponseDTO;



@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NoSuchFlightException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseDTO handleFlightException(NoSuchFlightException ex) {
		return ResponseDTO.builder().code(HttpStatus.NOT_FOUND.value()).message(ex.getMessage()).build();
	}
	
	
	@ExceptionHandler(value = NoSuchAccommodationException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseDTO handleAccommodationException(NoSuchAccommodationException ex) {
		return ResponseDTO.builder().code(HttpStatus.NOT_FOUND.value()).message(ex.getMessage()).build();
	}

}

