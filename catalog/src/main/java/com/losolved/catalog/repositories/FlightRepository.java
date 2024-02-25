package com.losolved.catalog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.losolved.catalog.model.Flight;
import com.losolved.catalog.model.Route;

import java.util.List;
import java.time.LocalDateTime;


public interface FlightRepository extends CrudRepository<Flight, Long> {
	
	 List<Flight> findByDepartureBetweenAndRoute(LocalDateTime startDeparture, LocalDateTime endDeparture, Route route);

}
