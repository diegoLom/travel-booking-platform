package com.losolved.catalog.services;

import com.losolved.catalog.dto.AccommodationDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.dto.filter.InLocationAndPriceBetween;
import com.losolved.catalog.dto.mapper.AccommodationMapper;
import com.losolved.catalog.errorhandling.NoSuchAccommodationException;
import com.losolved.catalog.model.Accommodation;
import com.losolved.catalog.model.Address;
import com.losolved.catalog.repositories.AccommodationRepository;

import lombok.Data;

import org.hibernate.boot.jaxb.mapping.marshall.OptimisticLockStyleMarshalling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class AccommodationService implements IAccomodationService {
	
	@Autowired
    private AccommodationRepository accommodationRepository;
    
	@Autowired
    private AccommodationMapper accommodationMapper;
	
	/// TODO: Develop a findAddress to get addressId
   
    public ResponseDTO arrange(AccommodationDTO accommodationDTO) {
    	
    	Accommodation accommodation = accommodationMapper.convertDTOToEntity(accommodationDTO);
    	
    	accommodationRepository.save(accommodation);
    	ResponseDTO responseDTO = ResponseDTO.builder().message("Accommodation set up").code(HttpStatus.CREATED.value()).build();
		return responseDTO;
    	
    }

    public Accommodation getAccommodation(Long id) {
        return accommodationRepository.findById(id)
                .orElseThrow(() -> new NoSuchAccommodationException("Accommodation with id " + id + " not found"));
    }

    public List<Accommodation> getAccommodation(InLocationAndPriceBetween filter) {
    	
    	List<Accommodation> listAccomodations =  accommodationRepository.findByAddressAndPriceBetween(
                filter.address(),
                filter.startPrice(),
                filter.endPrice()
        );
    	
    	if(listAccomodations.isEmpty()) throw new NoSuchAccommodationException();
    		
        return listAccomodations;
    }
    
    
    
    public ResponseDTO update(AccommodationDTO dto) {
    	ResponseDTO responseDTO = ResponseDTO.builder().message("Accommodation updated").code(HttpStatus.OK.value()).build();
    	
    	Accommodation oldAccommodation = getAccommodation(dto.getId());
    	Accommodation accommodation = getAccommodationMapper().convertDTOToEntity(dto);
    	accommodation.setId(oldAccommodation.getId());
    	
    	try {
    		accommodationRepository.save(accommodation);
    	}catch(OptimisticLockingFailureException opt) {
    		throw new NoSuchAccommodationException();
    	}
        return responseDTO;
    }

    public ResponseDTO cancel(AccommodationDTO dto) {
      
    	ResponseDTO responseDTO = ResponseDTO.builder().message("Accommodation canceled").code(HttpStatus.OK.value()).build();
    	Accommodation accommodation = getAccommodation(dto.getId());
        try {
    		accommodationRepository.delete(accommodation);
    	}catch(OptimisticLockingFailureException opt) {
    		throw new NoSuchAccommodationException();
    	}
        return responseDTO;
    }



}
