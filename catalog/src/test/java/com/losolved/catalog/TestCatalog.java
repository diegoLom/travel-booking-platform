package com.losolved.catalog;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.losolved.catalog.model.Flight;
import com.losolved.catalog.services.MockedCatalog;

public class TestCatalog {

	public static void main(String[] args) {
			
	 List<Flight> flights = MockedCatalog.getMockedFlights();
	 
	List result = flights.stream().map( x -> x.getDeparture()
).filter(x -> x.isAfter(LocalDateTime.now().plusDays(4))).collect(Collectors.toList());
System.out.println(" End of explanation "); 


	}

}
