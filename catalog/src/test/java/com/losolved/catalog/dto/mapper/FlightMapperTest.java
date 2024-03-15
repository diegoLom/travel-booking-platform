package com.losolved.catalog.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.losolved.catalog.dto.FlightDTO;

import com.losolved.catalog.model.Flight;
import com.losolved.catalog.model.Route;
import com.losolved.catalog.model.Address;
import com.losolved.catalog.model.Airline;

public class FlightMapperTest {

	private static FlightMapper flightMapper;

	@BeforeAll
	private static void setup() {
		flightMapper = new FlightMapper();
	}

	@Test
	public void testConvertToEntity() {

		LocalDateTime departure = LocalDateTime.now().plusDays(5);
		LocalDateTime arrival = LocalDateTime.now().plusDays(8);

		FlightDTO flightDTO = FlightDTO.builder().id(3l).number(3).departure(departure).arrival(arrival)
				.routeDepartureCity("Camaçari").routeDepartureState("Bahia")
				.routeDepartureStreet("Rua Décima do Parque").routeDepartureZipCode("42802323")
				.routeArrivalCity("Salvador").routeArrivalState("Bahia").routeArrivalStreet("Rio Vermelho")
				.routeArrivalZipCode("428234223").airlineCompanyDetails("GOL AIRLINES").airlineCompanyName("GOL")
				.build();

		Flight flight = flightMapper.convertDTOToEntity(flightDTO);

		assertionOfTheConvertion(flightDTO, flight);

	}

	@Test
	public void testConvertToDTO() {

		LocalDateTime departure = LocalDateTime.now().plusDays(5);
		LocalDateTime arrival = LocalDateTime.now().plusDays(8);

		Address addressDeparture = Address.builder().city("Camaçari").state("Bahia").street("Rua Décima do Parque")
				.zipCode("42802323").build();
		Address addressArrival = Address.builder().city("Salvador").state("Bahia").street("Rio Vermelho")
				.zipCode("428234323").build();

		Route route = Route.builder().arrival(addressArrival).departure(addressDeparture).build();
		Airline airline = Airline.builder().companyDetails("LINHAS AERES").companyName("GOL").build();

		Flight flight = Flight.builder().id(3l).number(92).route(route).arrival(arrival).departure(departure).airline(airline)
				.build();

		
		FlightDTO flightDTO = flightMapper.convertEntityToDTO(flight);

		assertionOfTheConvertion(flightDTO, flight);

	}

	public void assertionOfTheConvertion(FlightDTO flightDTO, Flight flight) {

		assertEquals(flight.getId(), flightDTO.getId());
		
		assertEquals(flight.getNumber(), flightDTO.getNumber());
		assertEquals(flight.getDeparture(), flightDTO.getDeparture());
		assertEquals(flight.getArrival(), flightDTO.getArrival());
		assertEquals(flight.getRoute().getArrival().getStreet(), flightDTO.getRouteArrivalStreet());
		assertEquals(flight.getRoute().getArrival().getCity(), flightDTO.getRouteArrivalCity());
		assertEquals(flight.getRoute().getArrival().getState(), flightDTO.getRouteArrivalState());
		assertEquals(flight.getRoute().getArrival().getZipCode(), flightDTO.getRouteArrivalZipCode());
		assertEquals(flight.getRoute().getDeparture().getStreet(), flightDTO.getRouteDepartureStreet());
		assertEquals(flight.getRoute().getDeparture().getCity(), flightDTO.getRouteDepartureCity());
		assertEquals(flight.getRoute().getDeparture().getState(), flightDTO.getRouteDepartureState());
		assertEquals(flight.getRoute().getDeparture().getZipCode(), flightDTO.getRouteDepartureZipCode());
		assertEquals(flight.getAirline().getCompanyName(), flightDTO.getAirlineCompanyName());
		assertEquals(flight.getAirline().getCompanyDetails(), flightDTO.getAirlineCompanyDetails());

	}

}
