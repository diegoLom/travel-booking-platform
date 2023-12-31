package com.losolved.catalog.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccommodationDTOTest {
	
	private static AccommodationDTO accommodation; 
	
	
	@BeforeAll
	private static void setup() {
		accommodation = AccommodationDTO.builder().build();
	}
	
	@Test
	public void testAccomodationNumber() {
		assertNull( accommodation.getNumber());
		final Integer number =  100;
		accommodation.setNumber(number);
		assertEquals(number, accommodation.getNumber());
		
	}
	
	@Test
	public void testStreet() { 
		//Default value
		assertEquals(accommodation.getStreet(), null); 
		
		final String street =  "Rua Décima do Parque";
		accommodation.setStreet(street); 
		assertEquals(accommodation.getStreet(), street); 
	}
	
	@Test
	public void testCity() {
		//Default value
		assertEquals(accommodation.getCity(), null); 
		final String city =  "California";
		accommodation.setCity(city); 
		assertEquals(accommodation.getCity(), city); 

	}
	
	@Test
	public void testState() {
		//Default value
		assertEquals(accommodation.getState(), null); 
		final String state =  "California";
		accommodation.setState(state); 
		assertEquals(accommodation.getState(), state); 

	}
	
	@Test
	public void testZipCode() {
		//Default value
		assertEquals(accommodation.getZipCode(), null); 
		final String zipCode =  "California";
		accommodation.setZipCode(zipCode); 
		assertEquals(accommodation.getZipCode(), zipCode); 
		
	}

}
