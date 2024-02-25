package com.losolved.catalog.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.losolved.catalog.model.Address;
import com.losolved.catalog.model.Airline;
import com.losolved.catalog.model.Flight;
import com.losolved.catalog.model.Route;

public class MockedCatalog {
	
	public static List<Flight> getMockedFlights() {
		LocalDateTime departureInFive = LocalDateTime.now().plusDays(5); 
		LocalDateTime departureInFour = LocalDateTime.now().plusDays(4); 
		LocalDateTime departureInThree = LocalDateTime.now().plusDays(3); 
		
		Flight fromCamacariToLondonThreeDays = Flight.builder().departure(departureInThree).route(fromCamacariToLondon()).build(); 
		Flight fromCamacariToLondonFourDays = Flight.builder().departure(departureInFour).route(fromCamacariToLondon()).build(); 
		Flight fromCamacariToLondonFiveDays = Flight.builder().departure(departureInFive).route(fromCamacariToLondon()).build(); 
		
		Flight fromSaoPauloToLondonThreeDays = Flight.builder().departure(departureInThree).route(fromSaoPauloToLondon()).build(); 
		Flight fromSaoPauloToLondonFourDays = Flight.builder().departure(departureInFour).route(fromSaoPauloToLondon()).build(); 
		Flight fromSaoPauloToLondonFiveDays = Flight.builder().departure(departureInFive).route(fromSaoPauloToLondon()).build(); 
		
		return Stream.of(fromCamacariToLondonFiveDays, fromCamacariToLondonFourDays, fromCamacariToLondonThreeDays, 
				fromSaoPauloToLondonFiveDays, fromSaoPauloToLondonFourDays, fromSaoPauloToLondonThreeDays
				).collect(Collectors.toList());
	}
	
	private static final String CAMACARI = "Camaçari";
	private static final String LONDON = "London";
	private static final String SAOPAULO = "São Paulo";
	
	
	//TODO: Add airport in data modeling 
	public static Route fromCamacariToLondon() {
		Address addressDeparture = Address.builder().city(CAMACARI).build();
		Address addressArrival = Address.builder().city(LONDON).build();

		Route route = Route.builder().arrival(addressArrival).departure(addressDeparture).build();
		return route;
	}
	
	public static Route fromSaoPauloToLondon() {
		Address addressDeparture = Address.builder().city(SAOPAULO).build();
		Address addressArrival = Address.builder().city(LONDON).build();

		Route route = Route.builder().arrival(addressArrival).departure(addressDeparture).build();
		return route;
	}
	
	public static Flight getMockedFlight() {
		LocalDateTime departure = LocalDateTime.now().plusDays(5);
		LocalDateTime arrival = LocalDateTime.now().plusHours(8);

		Address addressDeparture = Address.builder().city("Camaçari").state("Bahia").street("Rua Décima do Parque")
				.zipCode("42802323").build();
		Address addressArrival = Address.builder().city("Salvador").state("Bahia").street("Rio Vermelho")
				.zipCode("428234323").build();

		Route route = Route.builder().arrival(addressArrival).departure(addressDeparture).build();
		Airline airline = Airline.builder().companyDetails("LINHAS AERES").companyName("GOL").build();

		Flight flight = Flight.builder().number(92).route(route).arrival(arrival).departure(departure).airline(airline)
				.build();

		return flight;
	}

}
