package com.losolved.booking.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FlightTest {
	
	private static Flight flight; 
	
	@BeforeAll
	public void setup() {
		flight = Flight.builder().build();
	}

	@Test
	public void testFlightNumber() {
		assertEquals(0, flight.getNumber());
		final Integer number =  100;
		flight.setNumber(number);
		assertEquals(number, flight.getNumber());
		
	}

}
