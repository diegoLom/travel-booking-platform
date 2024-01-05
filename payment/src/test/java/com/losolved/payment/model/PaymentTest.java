package com.losolved.payment.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentTest {
	
	
	private static Payment payment;
	
	@BeforeAll
	private static void setup() {
		payment = Payment.builder().build();
		
	}
	
	@Test
	private void paymentMethodTest() {
		assertNull(payment.getMethod());
		
		String method = "Credit Card";
		payment.setMethod(method);
		assertEquals(payment.getMethod(),  method);
	}
	
	@Test	
	private void paymentProcessingDateTest() {
		assertNull(payment.getProcessingDate());
		
		LocalDateTime processingDate = LocalDateTime.now();
		payment.setProcessingDate	(processingDate);
		assertEquals(payment.getProcessingDate(),  processingDate);
	}
	
	@Test	
	private void paymentStatusTest() {
		assertNull(payment.getStatus());
		
		String status = "PENDING";
		payment.setStatus(status);
		assertEquals(payment.getStatus(),  status);
	}
	
	@Test
	private void paymentBookingIdTest() {
		assertEquals(0, payment.getBookingId());
		
		Long bookingId = Long.valueOf(8);
		payment.setBookingId(bookingId);
		assertEquals(payment.getBookingId(),  bookingId);
	}
	
	
	
	
	

}
