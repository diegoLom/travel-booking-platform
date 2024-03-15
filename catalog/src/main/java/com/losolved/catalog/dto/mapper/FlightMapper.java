package com.losolved.catalog.dto.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.losolved.catalog.dto.FlightDTO;
import com.losolved.catalog.model.Flight;

@Component
public class FlightMapper {
	
	private ModelMapper mapper = new ModelMapper();

	public Flight convertDTOToEntity(FlightDTO flightDTO) {
	
		mapper.typeMap(FlightDTO.class, Flight.class);
		
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // 
		Flight flight = mapper.map(flightDTO, Flight.class);
		return flight;
	}

	public FlightDTO convertEntityToDTO(Flight flight) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE); // 
		FlightDTO flightDTO = mapper.map(flight, FlightDTO.class);
		return flightDTO;
	}

}
