package com.losolved.catalog.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.losolved.catalog.dto.FlightDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.dto.filter.InDateBetweenAndRoute;
import com.losolved.catalog.errorhandling.NoSuchFlightException;
import com.losolved.catalog.model.Flight;
import com.losolved.catalog.services.FlightService;
import com.losolved.catalog.services.MockedCatalog;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @MockBean
    private FlightService flightService;

    @Autowired
    private MockMvc mockMvc;
 
    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public static void setup() {
        mapper = new ObjectMapper().registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
      
    }
    
    @Test
    public void givenARetrieveFlightsByDateRangeAndRoute() throws Exception {
    	List<Flight> flightFiltered = MockedCatalog.getFlightFiltered();
        given(flightService.getFlight(any(InDateBetweenAndRoute.class))).willReturn(MockedCatalog.getFlightFiltered());
    	LocalDateTime departureInFive = LocalDateTime.now().plusDays(5); 
		LocalDateTime departureInFour = LocalDateTime.now().plusDays(4); 
	
		InDateBetweenAndRoute  searchFilter = new InDateBetweenAndRoute( departureInFour, departureInFive, MockedCatalog.fromCamacariToLondon());
		String json = mapper.writeValueAsString(searchFilter);
        
        // Perform the request
        mockMvc.perform(get("/flight")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                // Add assertions for returned flights
                .andExpect(jsonPath("$", Matchers.hasSize(flightFiltered.size())));
     }


    @Test
    public void givenARetrieveFlightObject() throws Exception {
        final LocalDateTime departureDateTime = LocalDateTime.now().plusDays(2);
        FlightDTO retrievedFlight = FlightDTO.builder().id(1L).routeDepartureCity(MockedCatalog.CAMACARI).routeArrivalCity(MockedCatalog.SAOPAULO).departure(departureDateTime).build();

        Flight flight = MockedCatalog.getMockedFlight() ;
   //    Flight flight = flightService.getFlightMapper().convertDTOToEntity(retrievedFlight);
        given(flightService.getFlight(ArgumentMatchers.anyLong())).willReturn(flight );

        mockMvc.perform(get("/flight/".concat(retrievedFlight.getId().toString()))).andExpect(status().isOk()).
                andExpect(jsonPath("$.route.departure.city", Matchers.equalTo(MockedCatalog.CAMACARI))).
                andExpect(jsonPath("$.route.arrival.city", Matchers.equalTo(MockedCatalog.SAOPAULO))).
                andExpect(jsonPath("$.departure", Matchers.equalTo(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(flight.getDeparture()))))
                ;
    }

    @Test
    public void givenArrageOperation() throws Exception {
        given(flightService.arrange(ArgumentMatchers.any())).willReturn(ResponseDTO.builder().code(201).message("Flight set up").build());
        final LocalDateTime departureDateTime = LocalDateTime.now().plusDays(2);
        FlightDTO bodyDTO = FlightDTO.builder().id(1L).routeDepartureCity(MockedCatalog.CAMACARI).routeArrivalCity(MockedCatalog.SAOPAULO).departure(departureDateTime).build();
        String json = mapper.writeValueAsString(bodyDTO);
        mockMvc.perform(post("/flight").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json)). //.accept(MediaType.APPLICATION_JSON)).//
                andExpect(status().isCreated()).andExpect(jsonPath("$.code", Matchers.equalTo(201))).
                andExpect(jsonPath("$.message", Matchers.equalTo("Flight set up")));

    }

    @Test
    public void givenAUpdateFlight() throws Exception {
        given(flightService.update(ArgumentMatchers.any())).willReturn(ResponseDTO.builder().code(200).message("Flight reviewed").build());
        final LocalDateTime departureDateTime = LocalDateTime.now().plusDays(2);
        FlightDTO bodyDTO = FlightDTO.builder().id(1L).routeDepartureCity(MockedCatalog.CAMACARI).routeArrivalCity(MockedCatalog.SAOPAULO).departure(departureDateTime).build();
        String json = mapper.writeValueAsString(bodyDTO);
 
        mockMvc.perform(put("/flight").contentType(MediaType.APPLICATION_JSON).content(json)).
                andExpect(status().isOk()).andExpect(jsonPath("$.code", Matchers.equalTo(200))).
                andExpect(jsonPath("$.message", Matchers.equalTo("Flight reviewed")));
    }

    @Test
    public void givenAFlightUpdateNotFound() throws Exception {

        given(flightService.update(ArgumentMatchers.any())).willThrow(new NoSuchFlightException());

        final LocalDateTime departureDateTime = LocalDateTime.now().plusDays(2);
        FlightDTO bodyDTO = FlightDTO.builder().id(1L).routeDepartureCity(MockedCatalog.CAMACARI).routeArrivalCity(MockedCatalog.SAOPAULO).departure(departureDateTime).build();
        String json = mapper.writeValueAsString(bodyDTO);
  
        mockMvc.perform(put("/flight").contentType(MediaType.APPLICATION_JSON).content(json)).
                andExpect(status().isNotFound()).andExpect(jsonPath("$.code", Matchers.equalTo(HttpStatus.NOT_FOUND.value()))).
                andExpect(jsonPath("$.message", Matchers.equalTo("Flight not found")));

    }

    @Test
    public void givenACancelFlight() throws Exception {

        given(flightService.cancel(ArgumentMatchers.any())).willReturn(ResponseDTO.builder().code(200).message("Flight canceled").build());

        final LocalDateTime departureDateTime = LocalDateTime.now().plusDays(2);
        FlightDTO bodyDTO = FlightDTO.builder().id(1L).routeDepartureCity(MockedCatalog.CAMACARI).routeArrivalCity(MockedCatalog.SAOPAULO).departure(departureDateTime).build();
        String json = mapper.writeValueAsString(bodyDTO);
  
        mockMvc.perform(delete("/flight").contentType(MediaType.APPLICATION_JSON).content(json)).
                andExpect(status().isOk()).andExpect(jsonPath("$.code", Matchers.equalTo(HttpStatus.OK.value()))).
                andExpect(jsonPath("$.message", Matchers.equalTo("Flight canceled")));

    }

    @Test
    public void givenACancelFlightNotFound() throws Exception {

        given(flightService.cancel(ArgumentMatchers.any())).willThrow(new NoSuchFlightException());

        final LocalDateTime departureDateTime = LocalDateTime.now().plusDays(2);
        FlightDTO bodyDTO = FlightDTO.builder().id(1L).routeDepartureCity(MockedCatalog.CAMACARI).routeArrivalCity(MockedCatalog.SAOPAULO).departure(departureDateTime).build();
        String json = mapper.writeValueAsString(bodyDTO);
  
        mockMvc.perform(delete("/flight").contentType(MediaType.APPLICATION_JSON).content(json)).
                andExpect(status().isNotFound()).andExpect(jsonPath("$.code", Matchers.equalTo(HttpStatus.NOT_FOUND.value()))).
                andExpect(jsonPath("$.message", Matchers.equalTo("Flight not found")));

    }
}
