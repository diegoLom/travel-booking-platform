package com.losolved.catalog.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



public class FlightDTOTest {
	
	private static FlightDTO flightDTO ; 
	
	@BeforeAll
	private static void setup() {
		flightDTO = FlightDTO.builder().build();
	}

	@Test
	public void testFlightNumber() {
		assertNull(flightDTO.getNumber());
		final Integer number =  100;
		flightDTO.setNumber(number);
		assertEquals(number, flightDTO.getNumber());
		
	}
	
	@Test
	public void testFlightTimes() {
		
		assertNull(flightDTO.getDeparture());
		assertNull(flightDTO.getArrival()); 
		
		LocalDateTime scheduledDeparture = LocalDateTime.now().plusDays(1);
		LocalDateTime estimatedArrival = scheduledDeparture.plusDays(2);
		defineFlightTimes(scheduledDeparture, estimatedArrival);
		
		assertEquals(flightDTO.getDeparture(), scheduledDeparture);
		assertEquals(flightDTO.getArrival(), estimatedArrival);
		
	}

	
	public void defineFlightTimes(LocalDateTime departureTime, LocalDateTime arrivalTime) {
		flightDTO.setDeparture(departureTime);
		flightDTO.setArrival(arrivalTime);
		
	}

	@Test
	public void testStreetArrival() { 
		//Default value
		assertEquals(flightDTO.getRouteArrivalStreet(), null); 
		
		final String street =  "Rua Décima do Parque";
		flightDTO.setRouteArrivalStreet(street); 
		assertEquals(flightDTO.getRouteArrivalStreet(), street); 
	}
	
	@Test
	public void testCityArrival() {
		//Default value
		assertEquals(flightDTO.getRouteArrivalCity(), null); 
		final String city =  "California";
		flightDTO.setRouteArrivalCity(city); 
		assertEquals(flightDTO.getRouteArrivalCity(), city); 

	}
	
	@Test
	public void testStateArrival() {
		//Default value
		assertEquals(flightDTO.getRouteArrivalState(), null); 
		final String state =  "California";
		flightDTO.setRouteArrivalState(state); 
		assertEquals(flightDTO.getRouteArrivalState(), state); 

	}
	
	@Test
	public void testZipCodeArrival() {
		//Default value
		assertEquals(flightDTO.getRouteArrivalZipCode(), null); 
		final String zipCode =  "California";
		flightDTO.setRouteArrivalZipCode(zipCode); 
		assertEquals(flightDTO.getRouteArrivalZipCode(), zipCode); 
		
	}
	

	@Test
	public void testStreetDeparture() { 
		//Default value
		assertEquals(flightDTO.getRouteDepartureStreet(), null); 
		
		final String street =  "Rua Décima do Parque";
		flightDTO.setRouteDepartureStreet(street); 
		assertEquals(flightDTO.getRouteDepartureStreet(), street); 
	}
	
	@Test
	public void testCityDeparture() {
		//Default value
		assertEquals(flightDTO.getRouteDepartureCity(), null); 
		final String city =  "San Diego";
		flightDTO.setRouteDepartureCity(city); 
		assertEquals(flightDTO.getRouteDepartureCity(), city); 

	}
	
	@Test
	public void testStateDeparture() {
		//Default value
		assertEquals(flightDTO.getRouteDepartureState(), null); 
		final String state =  "California";
		flightDTO.setRouteDepartureState(state); 
		assertEquals(flightDTO.getRouteDepartureState(), state); 

	}
	
	@Test
	public void testZipCodeDeparture() {
		//Default value
		assertEquals(flightDTO.getRouteDepartureZipCode(), null); 
		final String zipCode =  "42803233";
		flightDTO.setRouteDepartureZipCode(zipCode); 
		assertEquals(flightDTO.getRouteDepartureZipCode(), zipCode); 
		
	}
	
	@Test
	public void testCompanyName() { 
		//Default value
		assertEquals(flightDTO.getAirlineCompanyName(), null); 
		
		final String companyName =  "GOL";
		flightDTO.setAirlineCompanyName(companyName); 
		assertEquals(flightDTO.getAirlineCompanyName(), companyName); 
	}
	
	@Test
	public void testCompanyDetails() { 
		//Default value
		assertEquals(flightDTO.getAirlineCompanyDetails(), null); 
		
		final String companyDetails =  "GOL Airlines";
		flightDTO.setAirlineCompanyDetails(companyDetails); 
		assertEquals(flightDTO.getAirlineCompanyDetails(), companyDetails); 
	} 
	
	

}
