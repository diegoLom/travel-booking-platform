package com.losolved.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.losolved.catalog.dto.FlightDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.dto.filter.InDateBetweenAndRoute;
import com.losolved.catalog.model.Flight;
import com.losolved.catalog.services.FlightService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/flight")
public class FlightController {
	
    @Autowired
    private FlightService flightService;


    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id) {
    	   Flight flight = flightService.getFlight(id);
        return ResponseEntity.ok(flight);
    }
    
    @GetMapping
    public ResponseEntity<List<Flight>> getFlightsByDateRangeAndRoute(@RequestBody InDateBetweenAndRoute inDateBetweenAndRoute) {
        List<Flight> flights = flightService.getFlight(inDateBetweenAndRoute);
        return ResponseEntity.ok(flights);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> arrangeFlight(@Valid @RequestBody FlightDTO flightDTO) {
        ResponseDTO responseDTO = flightService.arrange(flightDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateFlight(@Valid @RequestBody FlightDTO flightDTO) {
        ResponseDTO responseDTO = flightService.update(flightDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping 
    public ResponseEntity<ResponseDTO> cancelFlight(@Valid @RequestBody FlightDTO flightDTO) {
        ResponseDTO responseDTO = flightService.cancel(flightDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
