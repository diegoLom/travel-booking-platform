package com.losolved.catalog.errorhandling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ErrorDetailTest {
	
	private static ErrorDetail errorDetail;
	
	@BeforeAll
	private static void setup() {
		errorDetail = ErrorDetail.builder().build();
	}

	@Test
	private void testErrorDate() {
		assertNull(errorDetail.getOccurrenceDate());
		
		
		LocalDateTime occurDate = LocalDateTime.now();
		errorDetail.setOccurrenceDate(occurDate);
		
 		assertEquals(errorDetail.getOccurrenceDate(), occurDate);
	}
	
	@Test
	private void testMessage() {
		assertNull(errorDetail.getMessage());
		String message = "The fligth requested is no longer available ";
		
		errorDetail.setMessage(message);
		assertEquals(errorDetail.getMessage(), message);
	}
	
	@Test
	private void testDetail() {
		
		assertNull(errorDetail.getDetail());
		String detail = "Due to environmental conditions the fligth was postponed. Contat your Airline Company for reimbursement ";
		
		errorDetail.setDetail(detail);
		assertEquals(errorDetail.getDetail(), detail);
		
	}
}
