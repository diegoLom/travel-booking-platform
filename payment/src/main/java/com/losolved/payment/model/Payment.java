package com.losolved.payment.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId; 
		
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Long bookingId;
	
	private String method;
	
	private String status;
	
	private LocalDateTime processingDate;

}
