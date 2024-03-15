package com.losolved.catalog.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.losolved.catalog.dto.AccommodationDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.dto.filter.InLocationAndPriceBetween;
import com.losolved.catalog.model.Accommodation;


@Service
public interface IAccomodationService {
	
	Accommodation getAccommodation(Long accommodationId);
	
	List<Accommodation> getAccommodation(InLocationAndPriceBetween filter);
	 
	//List<Accommodation> findByAddress(Address address);

	ResponseDTO arrange(AccommodationDTO accommodationDTO);
	
	ResponseDTO update(AccommodationDTO accommodationDTO);
	
	ResponseDTO cancel(AccommodationDTO accommodationDTO);

}
