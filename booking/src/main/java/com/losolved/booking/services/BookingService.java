package com.losolved.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losolved.booking.dto.BookingDTO;
import com.losolved.booking.dto.BookingMapper;
import com.losolved.booking.dto.ResponseDTO;
import com.losolved.booking.model.Booking;
import com.losolved.booking.repositories.BookingRepository;

import lombok.Data;

@Service
@Data
public class BookingService implements IBookingService {
	
	@Autowired
	private BookingMapper bookingMapper;
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking getBooking(Long bookingId) {
		
		bookingRepository.findById(bookingId)
		return ;
	}

	@Override
	public ResponseDTO book(BookingDTO bookingDTO) {
		return null;
	}

	@Override
	public ResponseDTO reviewBooking(BookingDTO bookingDTO) {
		return null;
	}

	@Override
	public ResponseDTO undoBooking(BookingDTO bookingDTO) {
		return null;
	}

}
