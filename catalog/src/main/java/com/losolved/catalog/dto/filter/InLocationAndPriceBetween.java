package com.losolved.catalog.dto.filter;

import java.time.LocalDateTime;

import com.losolved.catalog.model.Address;
import com.losolved.catalog.model.Route;

public record InLocationAndPriceBetween(Address address, Double startPrice, Double endPrice) {

}
