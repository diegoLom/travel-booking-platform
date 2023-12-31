package com.losolved.catalog.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



public class FlightDTOTest {
	
	private static FlightDTO flightDTO ; 
	

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
		assertEquals(flightDTO.getStreetArrival(), null); 
		
		final String street =  "Rua Décima do Parque";
		flightDTO.setStreetArrival(street); 
		assertEquals(flightDTO.getStreetArrival(), street); 
	}
	
	@Test
	public void testCityArrival() {
		//Default value
		assertEquals(flightDTO.getCityArrival(), null); 
		final String city =  "California";
		flightDTO.setCityArrival(city); 
		assertEquals(flightDTO.getCityArrival(), city); 

	}
	
	@Test
	public void testStateArrival() {
		//Default value
		assertEquals(flightDTO.getStateArrival(), null); 
		final String state =  "California";
		flightDTO.setStateArrival(state); 
		assertEquals(flightDTO.getStateArrival(), state); 

	}
	
	@Test
	public void testZipCodeArrival() {
		//Default value
		assertEquals(flightDTO.getZipCodeArrival(), null); 
		final String zipCode =  "California";
		flightDTO.setZipCodeArrival(zipCode); 
		assertEquals(flightDTO.getZipCodeArrival(), zipCode); 
		
	}
	

	@Test
	public void testStreetDeparture() { 
		//Default value
		assertEquals(flightDTO.getStreetDeparture(), null); 
		
		final String street =  "Rua Décima do Parque";
		flightDTO.setStreetDeparture(street); 
		assertEquals(flightDTO.getStreetDeparture(), street); 
	}
	
	@Test
	public void testCityDeparture() {
		//Default value
		assertEquals(flightDTO.getCityDeparture(), null); 
		final String city =  "San Diego";
		flightDTO.setCityDeparture(city); 
		assertEquals(flightDTO.getCityDeparture(), city); 

	}
	
	@Test
	public void testStateDeparture() {
		//Default value
		assertEquals(flightDTO.getStateDeparture(), null); 
		final String state =  "California";
		flightDTO.setStateDeparture(state); 
		assertEquals(flightDTO.getStateDeparture(), state); 

	}
	
	@Test
	public void testZipCodeDeparture() {
		//Default value
		assertEquals(flightDTO.getZipCodeDeparture(), null); 
		final String zipCode =  "42803233";
		flightDTO.setZipCodeDeparture(zipCode); 
		assertEquals(flightDTO.getZipCodeDeparture(), zipCode); 
		
	}
	
	@Test
	public void testCompanyName() { 
		//Default value
		assertEquals(flightDTO.getCompanyName(), null); 
		
		final String companyName =  "GOL";
		flightDTO.setCompanyName(companyName); 
		assertEquals(flightDTO.getCompanyName(), companyName); 
	}
	
	@Test
	public void testCompanyDetails() { 
		//Default value
		assertEquals(flightDTO.getCompanyDetails(), null); 
		
		final String companyDetails =  "GOL Airlines";
		flightDTO.setCompanyDetails(companyDetails); 
		assertEquals(flightDTO.getCompanyDetails(), companyDetails); 
	} 
	
	

}
