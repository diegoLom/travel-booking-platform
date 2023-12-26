package com.losolved.catalog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.losolved.catalog.model.Airline;

public interface AirlineRepository extends CrudRepository<Airline, Long> {

}
