package com.losolved.payment.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class PaymentDTO {
	
	private Long bookingId;
	private String method;
	private String status;
	private LocalDateTime processingDate;

}
