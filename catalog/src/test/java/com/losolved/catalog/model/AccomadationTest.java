package com.losolved.catalog.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccomadationTest {
	
	
	private static Accommodation accommodation; 
	
	@BeforeAll
	public void setup() {
		accommodation = Accommodation.builder().build();
	}

	@Test
	public void testAccomodationNumber() {
		assertEquals(0, accommodation.getNumber());
		final Integer number =  100;
		accommodation.setNumber(number);
		assertEquals(number, accommodation.getNumber());
		
	}
	
}
