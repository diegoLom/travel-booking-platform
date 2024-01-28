package com.losolved.booking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import java.time.LocalDateTime;
import java.util.Optional;

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

import com.losolved.booking.dto.BookingDTO;
import com.losolved.booking.dto.ResponseDTO;
import com.losolved.booking.errorhandling.NoSuchBookingException;
import com.losolved.booking.model.Booking;
import com.losolved.booking.repositories.BookingRepository;

import net.bytebuddy.asm.Advice.Argument;

@SpringBootTest
public class BookingServiceTest {
	
	private BookingService bookingService;
	
	@MockBean
    private  BookingRepository bookingRepository;
	
	
    @Autowired
    public BookingServiceTest(BookingService bookingService) {
        this.bookingService = bookingService;
    }
   //TODO: All the wonderings should be taken note. Booking availability is made consulting others microservices. 
	
	@Test
	public void testBook() {
		Booking booking = getMockedBooking();
	
		 given(bookingRepository.save(ArgumentMatchers.any())).willReturn(getMockedBooking());
		 
		 BookingDTO bookingDTO = bookingService.getBookingMapper().convertEntityToDTO(booking);
		 ResponseDTO responseDTO = bookingService.book(bookingDTO);
		 
		 assertEquals(responseDTO.getCode(), HttpStatus.CREATED.value());
		 assertEquals(responseDTO.getMessage(), "Booking schedule");
	}
	
	@Test
	public void testFailureReviewBook() {
		Booking booking = getMockedBooking();
		booking.setId(1l);
		given(bookingRepository.save(booking)).willThrow(OptimisticLockingFailureException.class);
		
		BookingDTO bookingDTO = bookingService.getBookingMapper().convertEntityToDTO(booking);
		ResponseDTO responseDTO = bookingService.reviewBooking(bookingDTO);
		
		assertEquals(responseDTO.getCode(), HttpStatus.NOT_FOUND.value());
		assertEquals(responseDTO.getMessage(), "Booking not Found");
		
	}

	
	@Test
	public void testSuccessReviewBook() {
		Booking booking = getMockedBooking();
		booking.setId(1l);
		given(bookingRepository.save(ArgumentMatchers.any())).willReturn(booking);
		
		BookingDTO bookingDTO = bookingService.getBookingMapper().convertEntityToDTO(booking);
		ResponseDTO responseDTO = bookingService.reviewBooking(bookingDTO);
		
		assertEquals(responseDTO.getCode(), HttpStatus.OK.value());
		assertEquals(responseDTO.getMessage(), "Booking reviewd");
		
	}
	
	@Test
	public void testFailureRetrieveook() {
		given(bookingRepository.findById(ArgumentMatchers.anyLong())).willReturn(Optional.empty());
		assertThrows(NoSuchBookingException.class, () -> bookingService.reviewBooking(BookingDTO.builder().id(3l).build()));

		
	}
	
	@Test
	public void testSuccessRetrieveBook() {
		Booking bookingReturn = getMockedBooking();
		given(bookingRepository.findById(ArgumentMatchers.anyLong())).willReturn(Optional.of(bookingReturn));
	
		Booking booking = bookingService.getBooking(ArgumentMatchers.anyLong());
		assertEquals(booking.getAccommodationId(), bookingReturn.getAccommodationId());
		assertEquals(booking.getBookingDate(), bookingReturn.getBookingDate());
	}
	
	
	@Test
	public void testFailureUnBook() {
		doThrow(OptimisticLockingFailureException.class).when(bookingRepository).delete(ArgumentMatchers.any());
		assertThrows(NoSuchBookingException.class, () -> bookingService.undoBooking(BookingDTO.builder().id(3l).build()));
	}

	
	@Test
	public void testSuccessUnBook() {
		Booking booking = getMockedBooking();
		booking.setId(1l);
		BookingDTO bookingDTO = bookingService.getBookingMapper().convertEntityToDTO(booking);
		ResponseDTO responseDTO = bookingService.undoBooking(bookingDTO);
		
		Mockito.verify(bookingRepository).delete(booking);  //TODO: Look closely 
	}
	
	
	//TODO: Search how to do a search by other microservice 
	public Booking getMockedBooking() {
		return Booking.builder().accommodationId(2).bookingDate(LocalDateTime.now()).build();
	}

}
