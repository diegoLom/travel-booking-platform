package com.losolved.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.losolved.booking.dto.BookingDTO;
import com.losolved.booking.dto.BookingMapper;
import com.losolved.booking.dto.ResponseDTO;
import com.losolved.booking.model.Booking;
import com.losolved.booking.repositories.BookingRepository;

import lombok.Data;

import java.util.Optional;
@Service
@Data
public class BookingService implements IBookingService {
	
	@Autowired
	private BookingMapper bookingMapper;
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking getBooking(Long bookingId) { 
		Optional<Booking> oBooking = bookingRepository.findById(bookingId);
		return oBooking.isPresent() ? oBooking.get() : Booking.builder().build() ;
	}

	@Override
	public ResponseDTO book(BookingDTO bookingDTO) {
		Booking booking = bookingMapper.convertDTOToEntity(bookingDTO);
		Booking booked = bookingRepository.save(booking);
		
		ResponseDTO responseDTO = ResponseDTO.builder().message("Booking schedule").code(HttpStatus.CREATED.value()).build();
		return responseDTO;
	}

	@Override
	public ResponseDTO reviewBooking(BookingDTO bookingDTO) {
		ResponseDTO responseDTO = ResponseDTO.builder().message("Booking reviewd").code(HttpStatus.OK.value()).build();
		
		Booking booking = bookingMapper.convertDTOToEntity(bookingDTO);
		try {
			Booking reviewBooked = bookingRepository.save(booking);
		}catch(OptimisticLockingFailureException optLockException) {
			responseDTO = ResponseDTO.builder().message("Booking not Found").code(HttpStatus.NOT_FOUND.value()).build();
		}
		
		return responseDTO;
	}

	@Override
	public ResponseDTO undoBooking(BookingDTO bookingDTO) {
		ResponseDTO responseDTO = ResponseDTO.builder().message("Booking canceled").code(HttpStatus.OK.value()).build();
		
		Booking booking = bookingMapper.convertDTOToEntity(bookingDTO);
		try {
			bookingRepository.delete(booking);
		}catch(OptimisticLockingFailureException optLockException) {
			responseDTO = ResponseDTO.builder().message("Booking not Found").code(HttpStatus.NOT_FOUND.value()).build();
		}
		
		return responseDTO;

	}

}
