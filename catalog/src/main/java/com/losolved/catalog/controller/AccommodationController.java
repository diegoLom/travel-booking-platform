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

import com.losolved.catalog.dto.AccommodationDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.dto.filter.InLocationAndPriceBetween;
import com.losolved.catalog.model.Accommodation;
import com.losolved.catalog.services.AccommodationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {
	
	//TODO: Make available search filter endpoint
	
	@Autowired
    private AccommodationService accommodationService;

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> getAccommodation(@PathVariable Long id) {
    	   Accommodation accommodation = accommodationService.getAccommodation(id);
        return ResponseEntity.ok(accommodation);
    }
    
    @GetMapping
    public ResponseEntity<List<Accommodation>> getAccommodation(@RequestBody InLocationAndPriceBetween filter) {
    	List<Accommodation> accommodations = accommodationService.getAccommodation(filter);
        return ResponseEntity.ok(accommodations);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> arrangeAccommodation(@Valid @RequestBody AccommodationDTO accommodationDTO) {
        ResponseDTO responseDTO = accommodationService.arrange(accommodationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateAccommodation(@Valid @RequestBody AccommodationDTO accommodationDTO) {
        ResponseDTO responseDTO = accommodationService.update(accommodationDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping 
    public ResponseEntity<ResponseDTO> cancelAccommodation(@Valid @RequestBody AccommodationDTO accommodationDTO) {
        ResponseDTO responseDTO = accommodationService.cancel(accommodationDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
