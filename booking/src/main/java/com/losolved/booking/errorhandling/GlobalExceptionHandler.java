package com.losolved.booking.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.losolved.booking.dto.ResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NoSuchBookingException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseDTO handleException(NoSuchBookingException ex) {
		return ResponseDTO.builder().code(HttpStatus.NOT_FOUND.value()).message(ex.getMessage()).build();
	}

}

