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
	private static void setAddressup() {
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
		assertEquals(accommodation.getAddressStreet(), null); 
		final String street =  "Rua Décima do Parque";
		accommodation.setAddressStreet(street); 
		assertEquals(accommodation.getAddressStreet(), street); 
	}
	
	@Test
	public void testCity() {
		//Default value
		assertEquals(accommodation.getAddressCity(), null); 
		final String city =  "California";
		accommodation.setAddressCity(city); 
		assertEquals(accommodation.getAddressCity(), city); 

	}
	
	@Test
	public void testState() {
		//Default value
		assertEquals(accommodation.getAddressState(), null); 
		final String state =  "California";
		accommodation.setAddressState(state); 
		assertEquals(accommodation.getAddressState(), state); 

	}
	
	@Test
	public void testZipCode() {
		//Default value
		assertEquals(accommodation.getAddressZipCode(), null); 
		final String zipCode =  "California";
		accommodation.setAddressZipCode(zipCode); 
		assertEquals(accommodation.getAddressZipCode(), zipCode); 
		
	}

}
