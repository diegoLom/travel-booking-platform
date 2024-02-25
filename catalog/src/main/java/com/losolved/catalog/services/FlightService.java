package com.losolved.catalog.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.losolved.booking.model.Booking;
import com.losolved.catalog.dto.FlightDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.dto.filter.InDateBetweenAndRoute;
import com.losolved.catalog.dto.mapper.FlightMapper;
import com.losolved.catalog.model.Flight;
import com.losolved.catalog.model.Route;
import com.losolved.catalog.repositories.FlightRepository;

import lombok.Data;

@Data
@Service
public class FlightService  implements IFlightService {
	
	@Autowired
	private FlightMapper flightMapper;
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Flight getFlight(Long flightId) {
		Optional<Flight> oFlight = flightRepository.findById(flightId);
		return oFlight.isPresent() ? oFlight.get() : Flight.builder().build();
	}

	@Override
	public List<Flight> getFlight(InDateBetweenAndRoute arg0) {
		List<Flight> flights = flightRepository.findByDepartureBetweenAndRoute(arg0.starDeparture(), arg0.endDeparture(), arg0.route());
		return flights;
	}

	@Override
	public ResponseDTO arrange(FlightDTO flightDTO) {
		Flight flight = flightMapper.convertDTOToEntity(flightDTO);
		
		flightRepository.save(flight);
		ResponseDTO responseDTO = ResponseDTO.builder().message("Flight schedule").code(HttpStatus.CREATED.value()).build();
		return responseDTO;
	}

	@Override
	public ResponseDTO update(FlightDTO flightDTO) {
		ResponseDTO responseDTO = ResponseDTO.builder().message("Flight reviewd").code(HttpStatus.OK.value()).build();
		Flight flight = flightMapper.convertDTOToEntity(flightDTO);
		try {
			Flight updatedFlight = flightRepository.save(flight);
		}catch(OptimisticLockingFailureException optLockException) {
			responseDTO = ResponseDTO.builder().message("Flight not Found").code(HttpStatus.NOT_FOUND.value()).build();
		}
		
		return responseDTO;
	}

	@Override
	public ResponseDTO cancel(FlightDTO flightDTO) {
		ResponseDTO responseDTO = ResponseDTO.builder().message("Flight canceled").code(HttpStatus.OK.value()).build();
		
		Flight booking = flightMapper.convertDTOToEntity(flightDTO);
		try {
			flightRepository.delete(booking);
		}catch(OptimisticLockingFailureException optLockException) {
			responseDTO = ResponseDTO.builder().message("Flight not Found").code(HttpStatus.NOT_FOUND.value()).build();
		}
		
		return responseDTO;

		
		return null;
	}

}
