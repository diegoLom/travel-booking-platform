package com.losolved.booking.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookingDTOTest {
	
	private static BookingDTO bookingDTO;
	
	@BeforeAll
	private static void setup() {
		bookingDTO = BookingDTO.builder().build();
		
	}
	
	@Test
    public void testBookingAccommodation() {
    	assertNull(bookingDTO.getAccommodationId());
    	
    	final Integer accommodationId = 3;
		bookingDTO.setAccommodationId(accommodationId);
    	assertEquals(accommodationId, bookingDTO.getAccommodationId() ); 
    }
	
	@Test
    public void testBookingFlight() {
    	assertNull(bookingDTO.getFlightId());
    	
    	final Integer flightId = 3;
    	bookingDTO.setFlightId(flightId);
    	assertEquals(flightId, bookingDTO.getFlightId() ); 
    }
	
	@Test
    public void testBookingGuest() {
    	assertNull(bookingDTO.getGuest());
    	
    	final Integer guestNumber = 3;
    	
    	bookingDTO.setGuest(guestNumber);
    	assertEquals(guestNumber, bookingDTO.getGuest() ); 
    }


    @Test
    public void testTotalAmount() {
        // Test default value
        assertEquals(0.0, bookingDTO.getTotalAmount());

        // Test setter and getter
        double totalAmount = 100.00;
        bookingDTO.setTotalAmount(totalAmount);
        assertEquals(totalAmount, bookingDTO.getTotalAmount());
    }
    
    @Test
    public void testBookingDate() {
        // Test default value
        assertEquals(null, bookingDTO.getBookingDate());

        // Test setter and getter
        LocalDateTime bookingDate = LocalDateTime.now();
        bookingDTO.setBookingDate(bookingDate);
        assertEquals(bookingDate, bookingDTO.getBookingDate());
    }

}
