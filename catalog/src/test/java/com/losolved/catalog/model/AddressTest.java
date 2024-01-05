package com.losolved.catalog.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressTest {
	
	private static  Address address;
	
	@BeforeAll
	public static void setup() {
		address = Address.builder().build();
	}
	
	@Test
	public void testStreet() { 
		//Default value
		assertEquals(address.getStreet(), null); 
		
		final String street =  "Rua Décima do Parque";
		address.setStreet(street); 
		assertEquals(address.getStreet(), street); 
	}
	
	@Test
	public void testCity() {
		//Default value
		assertEquals(address.getCity(), null); 
		final String city =  "California";
		address.setCity(city); 
		assertEquals(address.getCity(), city); 

	}
	
	@Test
	public void testState() {
		//Default value
		assertEquals(address.getState(), null); 
		final String state =  "California";
		address.setState(state); 
		assertEquals(address.getState(), state); 

	}
	
	@Test
	public void testZipCode() {
		//Default value
		assertEquals(address.getZipCode(), null); 
		final String zipCode =  "California";
		address.setZipCode(zipCode); 
		assertEquals(address.getZipCode(), zipCode); 
		
	}
	
	
	//TODO: Adding reflection to validate the fields presents in class fit with bussiness rule 
	

}
