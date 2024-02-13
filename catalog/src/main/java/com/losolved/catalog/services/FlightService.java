package com.losolved.catalog.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losolved.catalog.dto.FlightDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.dto.mapper.FlightMapper;
import com.losolved.catalog.model.Flight;
import com.losolved.catalog.model.Route;

import lombok.Data;

@Data
@Service
public class FlightService  implements IFlightService {
	
	@Autowired
	private FlightMapper flightMapper;

	@Override
	public Flight getFlight(Long flightId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> findByDepartureBetweenAndRoute(LocalDateTime startDeparture, LocalDateTime endDeparture,
			Route route) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDTO arrange(FlightDTO flightDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDTO update(FlightDTO flightDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDTO cancel(FlightDTO flightDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
