package com.losolved.catalog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.losolved.catalog.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
