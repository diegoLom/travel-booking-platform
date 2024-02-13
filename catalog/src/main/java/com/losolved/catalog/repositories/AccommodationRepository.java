package com.losolved.catalog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.losolved.catalog.model.Accommodation;
import com.losolved.catalog.model.Address;

import java.util.List;


public interface AccommodationRepository extends CrudRepository<Accommodation, Long> {
	
	 List<Accommodation> findByAddressAndPriceBetween(Address address, Double startPrice, Double endPrice);
	 
	 List<Accommodation> findByAddress(Address address);

}
