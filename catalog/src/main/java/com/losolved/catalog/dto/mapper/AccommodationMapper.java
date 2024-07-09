package com.losolved.catalog.dto.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.losolved.catalog.dto.AccommodationDTO;

import com.losolved.catalog.model.Accommodation;


@Component
public class AccommodationMapper {
	
	private ModelMapper mapper = new ModelMapper();

	public Accommodation convertDTOToEntity(AccommodationDTO accommodationDTO) {
		mapper.typeMap(AccommodationDTO.class, Accommodation.class);

		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // 
		Accommodation accomodation = mapper.map(accommodationDTO, Accommodation.class);
		return accomodation;
	}

	public AccommodationDTO convertEntityToDTO(Accommodation accommodation) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE); // 
		AccommodationDTO accomodationDTO = mapper.map(accommodation, AccommodationDTO.class);
		return accomodationDTO;
	}

}
