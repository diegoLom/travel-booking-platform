package com.losolved.booking.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseEntityTest {
	
	private static Booking booking; 
	
	@BeforeAll
	private static void setup() {
		booking = Booking.builder().build();
	}
	
	
	@Test
	public void createdAtValidation() {
		final LocalDateTime now = LocalDateTime.now();
		booking.setCreatedAt(now); 
		assertEquals(booking.getCreatedAt(), now);
	}
	
	@Test
	public void createdByValidation() {
		final String author = "Diego Santos";
		booking.setCreatedBy(author);
		assertEquals(author, booking.getCreatedBy());
	}
	
	@Test
	public void updatedAtValidation() {
		final LocalDateTime now = LocalDateTime.now();
		booking.setUpdatedAt(now); 
		assertEquals(booking.getUpdatedAt(), now);
	}
	
	@Test
	public void updatedByValidation() {
		final String author = "Diego Santos";
		booking.setUpdatedBy(author);
		assertEquals(author, booking.getUpdatedBy());
	}
	
	

}
