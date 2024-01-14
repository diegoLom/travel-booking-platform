package com.losolved.booking.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.losolved.booking.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {
	
	//TODO: Add find by others attributes 
	
	

}
