package com.losolved.booking.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.losolved.booking.model.Booking;


@SpringBootTest
public class BookingMapperTest {
	
	private static BookingMapper bookingMapper;
	
	@BeforeAll
	private static void setup() {
		bookingMapper = new  BookingMapper();
	}
	
	@Test
	public void testConvertToEntity() {
		
		LocalDateTime bookingDate = LocalDateTime.now().plusHours(2);
		Integer guestNumber = 3;
		BookingDTO bookingDTO = BookingDTO.builder().accommodationId(1).bookingDate(bookingDate).flightId(2).guest(3).build();
		
		Booking booking = bookingMapper.convertDTOToEntity(bookingDTO);
		
		assertionOfTheConvertion(bookingDTO, booking );
		
	}
	@Test
	public void testConvertToDTO() {
		
		LocalDateTime bookingDate = LocalDateTime.now().plusHours(2);
		Integer guestNumber = 3;
		Booking booking = Booking.builder().accommodationId(1).bookingDate(bookingDate).flightId(2).guest(3).build();
		
		BookingDTO bookingDTO = bookingMapper.convertEntityToDTO(booking);
		
		assertionOfTheConvertion(bookingDTO, booking );
			
	}
	
	
	public void assertionOfTheConvertion(BookingDTO bookingDTO, Booking booking) {
		assertEquals(booking.getAccommodationId(), bookingDTO.getAccommodationId());
		assertEquals(booking.getFlightId(), bookingDTO.getFlightId());
		assertEquals(booking.getGuest(), bookingDTO.getGuest());
		assertEquals(booking.getBookingDate(), bookingDTO.getBookingDate());
	}

}
