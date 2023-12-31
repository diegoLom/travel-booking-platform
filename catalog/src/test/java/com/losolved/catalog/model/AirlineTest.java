package com.losolved.catalog.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AirlineTest {
	
	 private static Airline airline; 
	 
	@BeforeAll
	public static void setup() {
		airline = Airline.builder().build();
	}
	
	@Test
	public void testCompanyName() { 
		//Default value
		assertEquals(airline.getCompanyName(), null); 
		
		final String companyName =  "GOL";
		airline.setCompanyName(companyName); 
		assertEquals(airline.getCompanyName(), companyName); 
	}
	
	@Test
	public void testCompanyDetails() { 
		//Default value
		assertEquals(airline.getCompanyDetails(), null); 
		
		final String companyDetails =  "GOL AIRLINES";
		airline.setCompanyDetails(companyDetails); 
		assertEquals(airline.getCompanyDetails(), companyDetails); 
	} 
	 
	 //TODO: Search if is possible to create rules to prohibit commit a new class without a class test
	 //TODO: Add sonar plugin to the project 
	 
	

}
