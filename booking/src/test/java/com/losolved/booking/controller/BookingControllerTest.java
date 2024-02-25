package com.losolved.booking.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import com.losolved.booking.dto.BookingDTO;
import com.losolved.booking.dto.ResponseDTO;
import com.losolved.booking.errorhandling.NoSuchBookingException;
import com.losolved.booking.model.Booking;
import com.losolved.booking.services.BookingService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BookingControllerTest {
	
	@MockBean
	private BookingService bookingService;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@BeforeAll
	public static void setup() {
		mapper  = new ObjectMapper().registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
	}
	
	
	@Test
	public void givenARetrieveBookingObject() throws Exception{
		final LocalDateTime bookingDateTime = LocalDateTime.now().plusDays(2);
		Booking retrievedBooking = Booking.builder().id(1l).accommodationId(1).bookingDate(bookingDateTime).build();
		
		     
		given(bookingService.getBooking(ArgumentMatchers.anyLong())).willReturn(retrievedBooking);
		
		   mockMvc.perform(get("/book/".concat(retrievedBooking.getId().toString()))).andExpect(status().isOk()).
           andExpect(jsonPath("$.accommodationId", Matchers.equalTo(1))).
           andExpect(jsonPath("$.bookingDate", Matchers.equalTo(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(bookingDateTime)))).
           andExpect(jsonPath("$.id", Matchers.equalTo(1)));

	}
	
	@Test
	public void givenABookingOperation() throws Exception {
	
		given(bookingService.book(ArgumentMatchers.any())).willReturn(ResponseDTO.builder().code(201).message("Booking schedule").build());
		final LocalDateTime bookingDateTime = LocalDateTime.now().plusDays(2);
		BookingDTO bodyDTO = BookingDTO.builder().id(1l).accommodationId(1).bookingDate(bookingDateTime).build();
		String json = mapper.writeValueAsString(bodyDTO);
		mockMvc.perform(post("/book").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json)). //.accept(MediaType.APPLICATION_JSON)).//
		andExpect(status().isCreated()).andExpect(jsonPath("$.code", Matchers.equalTo(201))).
		andExpect(jsonPath("$.message", Matchers.equalTo("Booking schedule")));

	}
	
	@Test
	public void givenAReviewBooking() throws Exception {
	
		given(bookingService.reviewBooking(ArgumentMatchers.any())).willReturn(ResponseDTO.builder().code(200).message("Booking reviewd").build());
		final LocalDateTime bookingDateTime = LocalDateTime.now().plusDays(2);
		BookingDTO bodyDTO = BookingDTO.builder().id(1l).accommodationId(1).bookingDate(bookingDateTime).build();
		String json = mapper.writeValueAsString(bodyDTO);
	
		
		mockMvc.perform(put("/book").contentType(MediaType.APPLICATION_JSON).content(json)).
		andExpect(status().isOk()).andExpect(jsonPath("$.code", Matchers.equalTo(200))).
		andExpect(jsonPath("$.message", Matchers.equalTo("Booking reviewd")));

	}
	
	@Test
	public void givenABookingReviewNotFound() throws Exception {
	
		given(bookingService.reviewBooking(ArgumentMatchers.any())).willThrow(new NoSuchBookingException());
		
		final LocalDateTime bookingDateTime = LocalDateTime.now().plusDays(2);
		BookingDTO bodyDTO = BookingDTO.builder().id(1l).accommodationId(1).bookingDate(bookingDateTime).build();
		String json = mapper.writeValueAsString(bodyDTO);
	
		mockMvc.perform(put("/book").contentType(MediaType.APPLICATION_JSON).content(json)).
		andExpect(status().isNotFound()).andExpect(jsonPath("$.code", Matchers.equalTo(HttpStatus.NOT_FOUND.value()))).
		andExpect(jsonPath("$.message", Matchers.equalTo("Booking not found")));

	}
	
	@Test
	public void givenAnUnBooking() throws Exception {
	
		given(bookingService.undoBooking(ArgumentMatchers.any())).willReturn(ResponseDTO.builder().code(200).message("Booking canceled").build());
	
		final LocalDateTime bookingDateTime = LocalDateTime.now().plusDays(2);
		BookingDTO bodyDTO = BookingDTO.builder().id(1l).accommodationId(1).bookingDate(bookingDateTime).build();
		String json = mapper.writeValueAsString(bodyDTO);
		
		mockMvc.perform(delete("/book").contentType(MediaType.APPLICATION_JSON).content(json)).
		andExpect(status().isOk()).andExpect(jsonPath("$.code", Matchers.equalTo(HttpStatus.OK.value()))).
		andExpect(jsonPath("$.message", Matchers.equalTo("Booking canceled")));

	}
	
	@Test
	public void givenAnUnBookingNotFound() throws Exception {
	
		given(bookingService.undoBooking(ArgumentMatchers.any())).willThrow( new NoSuchBookingException());
		
		final LocalDateTime bookingDateTime = LocalDateTime.now().plusDays(2);
		BookingDTO bodyDTO = BookingDTO.builder().id(1l).accommodationId(1).bookingDate(bookingDateTime).build();
		String json = mapper.writeValueAsString(bodyDTO);
		
		mockMvc.perform(delete("/book").contentType(MediaType.APPLICATION_JSON).content(json)).
		andExpect(status().isNotFound()).andExpect(jsonPath("$.code", Matchers.equalTo(HttpStatus.NOT_FOUND.value()))).
		andExpect(jsonPath("$.message", Matchers.equalTo("Booking not found")));

	}


	
	
}
