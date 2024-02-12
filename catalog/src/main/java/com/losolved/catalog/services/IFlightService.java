package com.losolved.catalog.services;

import java.util.List;

import com.losolved.catalog.dto.FlightDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.model.Flight;

public interface IFlightService {
	
	Flight getFlight(Long bookingId);
	
	List<Flight> getFlightBy();
	
	//booking! 
	ResponseDTO book(FlightDTO bookingDTO);
	
	ResponseDTO reviewBooking(FlightDTO bookingDTO);
	
	ResponseDTO undoBooking(FlightDTO bookingDTO);

}
