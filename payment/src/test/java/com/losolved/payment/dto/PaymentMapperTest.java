package com.losolved.payment.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.losolved.payment.dto.PaymentDTO;
import com.losolved.payment.dto.PaymentMapper;
import com.losolved.payment.model.Payment;

public class PaymentMapperTest {
	
	private static PaymentMapper paymentMapper;
	
	@BeforeAll
	private static void setup() {
		paymentMapper = new  PaymentMapper();
	}
	
	@Test
	public void testConvertToEntity() {
		
		LocalDateTime paymentDate = LocalDateTime.now().plusHours(2);
		Integer guestNumber = 3;
		PaymentDTO paymentDTO = PaymentDTO.builder().bookingId(1l).processingDate(paymentDate).method("Debit").status("APPROVED").build();
		
		Payment payment = paymentMapper.convertDTOToEntity(paymentDTO);
		
		assertionOfTheConvertion(paymentDTO, payment );
		
	}
	@Test
	public void testConvertToDTO() {
		
		LocalDateTime paymentDate = LocalDateTime.now().plusHours(2);
		Integer guestNumber = 3;
		Payment payment = Payment.builder().bookingId(1l).processingDate(paymentDate).method("Credit").status("PENDING").build();
		
		PaymentDTO paymentDTO = paymentMapper.convertEntityToDTO(payment);
		
		assertionOfTheConvertion(paymentDTO, payment );
			
	}
	
	
	public void assertionOfTheConvertion(PaymentDTO paymentDTO, Payment payment) {
		assertEquals(payment.getBookingId(), paymentDTO.getBookingId());
		assertEquals(payment.getMethod(), paymentDTO.getMethod());
		assertEquals(payment.getStatus(), paymentDTO.getStatus());
		assertEquals(payment.getProcessingDate(), paymentDTO.getProcessingDate());
	}

}
