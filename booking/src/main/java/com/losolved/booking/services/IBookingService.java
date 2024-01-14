package com.losolved.booking.services;

import com.losolved.booking.dto.BookingDTO;
import com.losolved.booking.dto.BookingMapper;
import com.losolved.booking.dto.ResponseDTO;
import com.losolved.booking.model.Booking;

public interface IBookingService {
	
	Booking getBooking(Long bookingId);
	
	//booking! 
	ResponseDTO book(BookingDTO bookingDTO);
	
	ResponseDTO reviewBooking(BookingDTO bookingDTO);
	
	ResponseDTO undoBooking(BookingDTO bookingDTO);

}
