package com.losolved.booking.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.losolved.booking.model.Booking;

import lombok.Builder;


@Service
public class BookingMapper {
	
	@Autowired //TODO: See why the dependency wasn't injected.
	private ModelMapper mapper = new ModelMapper();;

	public Booking convertDTOToEntity(BookingDTO bookingDTO) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // 
		Booking booking = mapper.map(bookingDTO, Booking.class);
		return booking;
	}

	public BookingDTO convertEntityToDTO(Booking booking) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		BookingDTO bookingDTO = mapper.map(booking, BookingDTO.class);
		return bookingDTO;
	
	}
	
	

}
