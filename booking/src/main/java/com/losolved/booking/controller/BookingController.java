package com.losolved.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.losolved.booking.dto.BookingDTO;
import com.losolved.booking.dto.BookingFlightDTO;
import com.losolved.booking.dto.ResponseDTO;
import com.losolved.booking.model.Booking;
import com.losolved.booking.services.BookingService;

@RestController
@RequestMapping("/book")
public class BookingController {
	
	//TODO: Do with the accommodation 
		
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("{id}")
	public ResponseEntity<Booking> getBooking(@PathVariable Long id){
		Booking booking = bookingService.getBooking(id);
		return new ResponseEntity<>(booking, HttpStatus.OK);
	}
	
	//TODO: Make with accommodation too 
	//TODO:   Adding Logger WITH correlation Id
	@GetMapping("/fetchFlightBooked/{id}")
	public ResponseEntity<BookingFlightDTO> fetchBooking(@PathVariable Long id){
		BookingFlightDTO bookingFlight = bookingService.getBookingWithFlight(id);
		return new ResponseEntity<>(bookingFlight, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResponseDTO> book(@RequestBody BookingDTO bookingDTO){
		ResponseDTO responseDTO = bookingService.book(bookingDTO);
		
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ResponseDTO> reviewBook(@RequestBody BookingDTO bookingDTO){
		ResponseDTO responseDTO = bookingService.reviewBooking(bookingDTO);
		
		return new ResponseEntity<>(responseDTO, HttpStatusCode.valueOf(responseDTO.getCode()) );
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseDTO> undoBook(@RequestBody BookingDTO bookingDTO){
		ResponseDTO responseDTO = bookingService.undoBooking(bookingDTO);
		
		return new ResponseEntity<>(responseDTO, HttpStatusCode.valueOf(responseDTO.getCode()) );
	}


}
