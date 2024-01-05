package com.losolved.payment.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.losolved.payment.dto.PaymentDTO;

public class PaymentDTOTest {
	
	private static PaymentDTO paymentDTO;
	
	@BeforeAll
	private static void setup() {
		paymentDTO = PaymentDTO.builder().build();
		
	}
	
	@Test
	private void paymentMethodTest() {
		assertNull(paymentDTO.getMethod());
		
		String method = "Credit Card";
		paymentDTO.setMethod(method);
		assertEquals(paymentDTO.getMethod(),  method);
	}
	
	@Test	
	private void paymentProcessingDateTest() {
		assertNull(paymentDTO.getProcessingDate());
		
		LocalDateTime processingDate = LocalDateTime.now();
		paymentDTO.setProcessingDate	(processingDate);
		assertEquals(paymentDTO.getProcessingDate(),  processingDate);
	}
	
	@Test	
	private void paymentStatusTest() {
		assertNull(paymentDTO.getStatus());
		
		String status = "PENDING";
		paymentDTO.setStatus(status);
		assertEquals(paymentDTO.getStatus(),  status);
	}
	
	@Test
	private void paymentBookingIdTest() {
		assertEquals(0, paymentDTO.getBookingId());
		
		Long bookingId = Long.valueOf(8);
		paymentDTO.setBookingId(bookingId);
		assertEquals(paymentDTO.getBookingId(),  bookingId);
	}

}
