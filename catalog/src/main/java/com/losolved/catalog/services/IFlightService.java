package com.losolved.catalog.services;

import java.time.LocalDateTime;
import java.util.List;

import com.losolved.catalog.dto.FlightDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.dto.filter.InDateBetweenAndRoute;
import com.losolved.catalog.model.Flight;
import com.losolved.catalog.model.Route;

public interface IFlightService {
	
	Flight getFlight(Long flightId);
	
	List<Flight> getFlight(InDateBetweenAndRoute inDateBeteweenAndROute);

	ResponseDTO arrange(FlightDTO flightDTO);
	
	ResponseDTO update(FlightDTO flightDTO);
	
	ResponseDTO cancel(FlightDTO flightDTO);

}
