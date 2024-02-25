package com.losolved.catalog.dto.filter;

import java.time.LocalDateTime;

import com.losolved.catalog.model.Route;

public record InDateBetweenAndRoute(LocalDateTime starDeparture, LocalDateTime endDeparture, Route route) {

}
