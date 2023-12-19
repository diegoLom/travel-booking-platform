package com.losolved.catalog.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

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
	
	@Test
	public void testFlightTimes() {
		
		assertNull(flight.getDeparture());
		assertNull(flight.getArrival()); 
		
		LocalDateTime scheduledDeparture = LocalDateTime.now().plusDays(1);
		LocalDateTime estimatedArrival = scheduledDeparture.plusDays(2);
		defineFlightTimes(scheduledDeparture, estimatedArrival);
		
		assertEquals(flight.getDeparture(), scheduledDeparture);
		assertEquals(flight.getArrival(), estimatedArrival);
		
	}

	
	public void defineFlightTimes(LocalDateTime departureTime, LocalDateTime arrivalTime) {
		flight.setDeparture(departureTime);
		flight.setArrival(arrivalTime);
		
	}
}
