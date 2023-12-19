package com.losolved.booking.model;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
public class BookingTest {
	
	private static Booking booking; 
	
	@BeforeAll
	private static void setup() {
		booking = Booking.builder().build();
	}
	
	@Test
    public void testBookingGuest() {
    	assertEquals(0, booking.getGuest());
    	
    	final Integer guestNumber = 3;
    	
    	booking.setGuest(guestNumber);
    	assertEquals(guestNumber, booking.getGuest() ); 
    }

    @Test
    public void testBookingDate() {
        // Test default value
        assertEquals(null, booking.getBookingDate());

        // Test setter and getter
        LocalDateTime bookingDate = LocalDateTime.now();
        booking.setBookingDate(bookingDate);
        assertEquals(bookingDate, booking.getBookingDate());
    }

    @Test
    public void testTotalAmount() {
        // Test default value
        assertEquals(0.0, booking.getTotalAmount());

        // Test setter and getter
        double totalAmount = 100.00;
        booking.setTotalAmount(totalAmount);
        assertEquals(totalAmount, booking.getTotalAmount());
    }
}
