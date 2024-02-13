package com.losolved.catalog.services;

import java.time.LocalDateTime;
import java.util.List;

import com.losolved.catalog.dto.AccommodationDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.model.Accommodation;
import com.losolved.catalog.model.Address;

public interface IAccomodationService {
	
	Accommodation getAccommodation(Long accommodationId);
	
	List<Accommodation> findByAddressAndPriceBetween(Address address, Double startPrice, Double endPrice);
	 
	List<Accommodation> findByAddress(Address address);

	ResponseDTO arrangeAccommodation(AccommodationDTO accommodationDTO);
	
	ResponseDTO updateAccommodation(AccommodationDTO accommodationDTO);
	
	ResponseDTO cancellAccommodation(AccommodationDTO accommodationDTO);

}
