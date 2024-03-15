package com.losolved.catalog.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.losolved.catalog.dto.AccommodationDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.dto.filter.InLocationAndPriceBetween;
import com.losolved.catalog.dto.mapper.AccommodationMapper;
import com.losolved.catalog.errorhandling.NoSuchAccommodationException;
import com.losolved.catalog.model.Accommodation;
import com.losolved.catalog.model.Address;
import com.losolved.catalog.services.AccommodationService;
import com.losolved.catalog.services.MockedCatalog;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccommodationController.class)
public class AccommodationControllerTest {

    @MockBean
    private AccommodationService accommodationService;

    @Autowired
    private MockMvc mockMvc;
    
	private static ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public static void setup() {
        mapper = new ObjectMapper().registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
      
    }

    @Test
    public void givenARetrieveAccommodationObject() throws Exception {
        Accommodation accommodation = MockedCatalog.getAccommodation();
        accommodation.setId(2l);
      // Accommodation accommodation = accommodationService.getAccommodationMapper().convertDTOToEntity(retrievedAccommodation);
        given(accommodationService.getAccommodation(ArgumentMatchers.anyLong())).willReturn(accommodation );

        mockMvc.perform(get("/accommodation/".concat(accommodation.getId().toString()))).andExpect(status().isOk()).
                andExpect(jsonPath("$.price", Matchers.equalTo(accommodation.getPrice()))).
                andExpect(jsonPath("$.address.city", Matchers.equalTo(accommodation.getAddress().getCity())));
    }
    

    @Test
    public void givenARetrieveAccommodationsByLocationAndPriceRange() throws Exception {
		Double startPrice = 100.00;
		Double endPrice = 200.00;

		Address address = Address.builder().city(MockedCatalog.CAMACARI).state("Bahia").street("Gleba C")
				.zipCode("428234323").build();

		InLocationAndPriceBetween inLocationAndPriceBetween = new InLocationAndPriceBetween(address, startPrice,
				endPrice);
		List<Accommodation> accommodationsFilter = MockedCatalog.getAccommodationsFiltered(); 
    	  given(accommodationService.getAccommodation(inLocationAndPriceBetween)).willReturn(accommodationsFilter);
    	  String json = mapper.writeValueAsString(inLocationAndPriceBetween);
    	  
    	  
    	  mockMvc.perform(get("/accommodation").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                  .content(json)). //.accept(MediaType.APPLICATION_JSON)).
                  andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(accommodationsFilter.size())))
                  ;
    	     
    	 
    }

    @Test
    public void givenArrageOperation() throws Exception {
        given(accommodationService.arrange(ArgumentMatchers.any())).willReturn(ResponseDTO.builder().code(201).message("Accommodation set up").build());
           AccommodationDTO bodyDTO = AccommodationDTO.builder().id(1L).addressCity(MockedCatalog.CAMACARI).number(32).price(200.00).build();
        String json = mapper.writeValueAsString(bodyDTO);
        mockMvc.perform(post("/accommodation").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json)). //.accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isCreated()).andExpect(jsonPath("$.code", Matchers.equalTo(201))).
                andExpect(jsonPath("$.message", Matchers.equalTo("Accommodation set up")));
   }

    @Test
    public void givenAUpdateAccommodation() throws Exception {

        given(accommodationService.update(ArgumentMatchers.any())).willReturn(ResponseDTO.builder().code(200).message("Accommodation reviewed").build());
        final LocalDateTime departureDateTime = LocalDateTime.now().plusDays(2);
        AccommodationDTO bodyDTO = AccommodationDTO.builder().id(1L).addressCity(MockedCatalog.CAMACARI).number(32).price(200.00).build();
          String json = mapper.writeValueAsString(bodyDTO);
      

        mockMvc.perform(put("/accommodation").contentType(MediaType.APPLICATION_JSON).content(json)).
                andExpect(status().isOk()).andExpect(jsonPath("$.code", Matchers.equalTo(200))).
                andExpect(jsonPath("$.message", Matchers.equalTo("Accommodation reviewed")));

    }

    @Test
    public void givenAAccommodationUpdateNotFound() throws Exception {

        given(accommodationService.update(ArgumentMatchers.any())).willThrow(new NoSuchAccommodationException());

        final LocalDateTime departureDateTime = LocalDateTime.now().plusDays(2);
        AccommodationDTO bodyDTO = AccommodationDTO.builder().id(1L).addressCity(MockedCatalog.CAMACARI).number(32).price(200.00).build();
          String json = mapper.writeValueAsString(bodyDTO);
  
        mockMvc.perform(put("/accommodation").contentType(MediaType.APPLICATION_JSON).content(json)).
                andExpect(status().isNotFound()).andExpect(jsonPath("$.code", Matchers.equalTo(HttpStatus.NOT_FOUND.value()))).
                andExpect(jsonPath("$.message", Matchers.equalTo("Accommodation not found")));

    }

    @Test
    public void givenACancelAccommodation() throws Exception {
    	given(accommodationService.cancel(ArgumentMatchers.any())).willReturn(ResponseDTO.builder().code(200).message("Accommodation canceled").build());

        final LocalDateTime departureDateTime = LocalDateTime.now().plusDays(2);
        AccommodationDTO bodyDTO = AccommodationDTO.builder().id(1L).addressCity(MockedCatalog.CAMACARI).number(32).price(200.00).build();
            String json = mapper.writeValueAsString(bodyDTO);
  
        mockMvc.perform(delete("/accommodation").contentType(MediaType.APPLICATION_JSON).content(json)).
                andExpect(status().isOk()).andExpect(jsonPath("$.code", Matchers.equalTo(HttpStatus.OK.value()))).
                andExpect(jsonPath("$.message", Matchers.equalTo("Accommodation canceled")));
   }

    @Test
    public void givenACancelAccommodationNotFound() throws Exception {
    	given(accommodationService.cancel(ArgumentMatchers.any())).willThrow(new NoSuchAccommodationException());

        final LocalDateTime departureDateTime = LocalDateTime.now().plusDays(2);
        AccommodationDTO bodyDTO = AccommodationDTO.builder().id(1L).addressCity(MockedCatalog.CAMACARI).number(32).price(200.00).build();
          String json = mapper.writeValueAsString(bodyDTO);
  
        mockMvc.perform(delete("/accommodation").contentType(MediaType.APPLICATION_JSON).content(json)).
                andExpect(status().isNotFound()).andExpect(jsonPath("$.code", Matchers.equalTo(HttpStatus.NOT_FOUND.value()))).
                andExpect(jsonPath("$.message", Matchers.equalTo("Accommodation not found")));

    }
}
