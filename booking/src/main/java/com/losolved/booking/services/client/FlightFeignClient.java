package com.losolved.booking.services.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.losolved.booking.dto.FlightDTO;



@FeignClient("flight")
public interface FlightFeignClient {
    
	@GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable Long id);
}
