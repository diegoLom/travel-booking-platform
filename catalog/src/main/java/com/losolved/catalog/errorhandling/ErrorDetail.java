package com.losolved.catalog.errorhandling;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDetail {
	
	private LocalDateTime occurrenceDate;
	private String message;
	private String detail;

}
