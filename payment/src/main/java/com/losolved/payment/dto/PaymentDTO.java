package com.losolved.payment.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaymentDTO {
	
	private Long bookingId;
	private String method;
	private String status;
	private LocalDateTime processingDate;

}
