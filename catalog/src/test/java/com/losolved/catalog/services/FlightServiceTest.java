package com.losolved.catalog.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;

import com.losolved.catalog.dto.FlightDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.model.Address;
import com.losolved.catalog.model.Airline;
import com.losolved.catalog.model.Flight;
import com.losolved.catalog.model.Route;
import com.losolved.catalog.repositories.FlightRepository;

import net.bytebuddy.asm.Advice.Argument;
import com.losolved.catalog.errorhandling.NoSuchFlightException;
@SpringBootTest
public class FlightServiceTest {
	
	
	private FlightService flightService;
	
	@MockBean
    private  FlightRepository flightRepository;
	
	
    @Autowired
    public FlightServiceTest(FlightService flightService) {
        this.flightService = flightService;
    }
   //TODO: All the wonderings should be taken note. Flight availability is made consulting others microservices. 
	
	@Test
	public void testArragenment() {
		Flight flight = MockedCatalog.getMockedFlight();
	
		 given(flightRepository.save(ArgumentMatchers.any())).willReturn(MockedCatalog.getMockedFlight());
		 
		 FlightDTO flightDTO = flightService.getFlightMapper().convertEntityToDTO(flight);
		 ResponseDTO responseDTO = flightService.arrange(flightDTO);
		 
		 assertEquals(responseDTO.getCode(), HttpStatus.CREATED.value());
		 assertEquals(responseDTO.getMessage(), "Flight schedule");
	}
	
	@Test
	public void testFailureUpdateFlight() {
		Flight flight = MockedCatalog.getMockedFlight();
		flight.setId(1l);
		given(flightRepository.save(flight)).willThrow(OptimisticLockingFailureException.class);
		
		FlightDTO flightDTO = flightService.getFlightMapper().convertEntityToDTO(flight);
		ResponseDTO responseDTO = flightService.update(flightDTO);
		
		assertEquals(responseDTO.getCode(), HttpStatus.NOT_FOUND.value());
		assertEquals(responseDTO.getMessage(), "Flight not Found");
		
	}

	
	@Test
	public void testSuccessUpdateFlight() {
		Flight flight = MockedCatalog.getMockedFlight();
		flight.setId(1l);
		given(flightRepository.save(ArgumentMatchers.any())).willReturn(flight);
		
		FlightDTO flightDTO = flightService.getFlightMapper().convertEntityToDTO(flight);
		ResponseDTO responseDTO = flightService.update(flightDTO);
		
		assertEquals(responseDTO.getCode(), HttpStatus.OK.value());
		assertEquals(responseDTO.getMessage(), "Flight reviewd");
		
	}
	
	@Test
	public void testFailureRetrieveook() {
		given(flightRepository.findById(ArgumentMatchers.anyLong())).willReturn(Optional.empty());
		assertThrows(NoSuchFlightException.class, () -> flightService.update(FlightDTO.builder().flightId(3l).build()));

		
	}
	
	@Test
	public void testSuccessRetrieveFlight() {
		Flight flightReturn = MockedCatalog.getMockedFlight();
		given(flightRepository.findById(ArgumentMatchers.anyLong())).willReturn(Optional.of(flightReturn));
	
		Flight flight = flightService.getFlight(ArgumentMatchers.anyLong());
		assertEquals(flight.getDeparture(), flightReturn.getDeparture());
		assertEquals(flight.getArrival(), flightReturn.getArrival());
	}
	
	@Test
	public void testRetrieveByDepartureBetweenAndRoute() {
		
		List<Flight> allFlights = MockedCatalog.getMockedFlights();
		
	 
		Flight flightReturn = MockedCatalog.getMockedFlight();
		given(flightRepository.findById(ArgumentMatchers.anyLong())).willReturn(Optional.of(flightReturn));
	
		
		flightRepository.findByDepartureBetweenAndRoute(null, null, null); 
		
		
		Flight flight = flightService.getFlight(ArgumentMatchers.anyLong());
		assertEquals(flight.getDeparture(), flightReturn.getDeparture());
		assertEquals(flight.getArrival(), flightReturn.getArrival());
	}
	
	
	@Test
	public void testFailureCancel() {
		doThrow(OptimisticLockingFailureException.class).when(flightRepository).delete(ArgumentMatchers.any());
		assertThrows(NoSuchFlightException.class, () -> flightService.cancel(FlightDTO.builder().flightId(3l).build()));
	}
	//TODO: Search how to do a search by  o m

	
	@Test
	public void testSuccessCancel() {
		Flight flight = MockedCatalog.getMockedFlight();
		flight.setId(1l);
		FlightDTO flightDTO = flightService.getFlightMapper().convertEntityToDTO(flight);
		ResponseDTO responseDTO = flightService.cancel(flightDTO);
		
		Mockito.verify(flightRepository).delete(flight);  //TODO: Look closely 
	}

}
