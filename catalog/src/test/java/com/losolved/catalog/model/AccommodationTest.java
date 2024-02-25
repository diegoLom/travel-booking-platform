package com.losolved.catalog.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccommodationTest {
	
	
	private static Accommodation accommodation; 
	
	@BeforeAll
	public static void setup() {
		accommodation = Accommodation.builder().build();
	}

	@Test
	public void testAccomodationNumber() {
		assertNull( accommodation.getNumber());
		final Integer number =  100;
		accommodation.setNumber(number);
		assertEquals(number, accommodation.getNumber());
		
	}
	
	@Test
	public void testDetail() {
		//TODO: Develop others attribute 
		assertNull(accommodation.getDetail());
		final String detail = "Hidromassage available";
		accommodation.setDetail(detail);
		
		assertEquals(accommodation.getDetail(), detail);
		
	}
	
	@Test
	public void testPrice() {
		//TODO: Develop amenity later on 
		assertNull(accommodation.getPrice());
		Double price = 50.00;
		accommodation.setPrice(price);
		assertEquals(accommodation.getPrice(), price);
		
	}
	
}
