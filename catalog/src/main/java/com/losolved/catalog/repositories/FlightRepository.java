package com.losolved.catalog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.losolved.catalog.model.Flight;

public interface FlightRepository extends CrudRepository<Flight, Long> {

}
