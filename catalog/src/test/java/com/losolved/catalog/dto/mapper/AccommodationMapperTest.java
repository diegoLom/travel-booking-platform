package com.losolved.catalog.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.losolved.catalog.dto.AccommodationDTO;
import com.losolved.catalog.model.Accommodation;
import com.losolved.catalog.model.Address;


public class AccommodationMapperTest {
	
	private static AccommodationMapper accommodationMapper;
	
	@BeforeAll
	private static void setup() {
		accommodationMapper = new  AccommodationMapper();
	}
	
	@Test
	public void testConvertToEntity() {
		
		LocalDateTime accommodationDate = LocalDateTime.now().plusHours(2);
		Integer guestNumber = 3;
		AccommodationDTO accommodationDTO = AccommodationDTO.builder().addressCity("Camaçari").number(92).addressState("Bahia").addressStreet("Rua Décima do Parque").addressZipCode("42802323").build();
		Address  address = Address.builder().city("Camaçari").state("Bahia").street("Rua Décima do Parque").zipCode("42802323").build();
		
		
		Accommodation accommodation = accommodationMapper.convertDTOToEntity(accommodationDTO);
		accommodation.builder().address(address).build();
		
		assertionOfTheConvertion(accommodationDTO, accommodation );
		
	}
	@Test
	public void testConvertToDTO() {
		Address  address = Address.builder().city("Camaçari").state("Bahia").street("Rua Décima do Parque").zipCode("42802323").build();
	
		Accommodation accommodation =  Accommodation.builder().number(92).address(address).build();
		
		AccommodationDTO accommodationDTO = accommodationMapper.convertEntityToDTO(accommodation);
		
		assertionOfTheConvertion(accommodationDTO, accommodation );
			
	}
	
	
	public void assertionOfTheConvertion(AccommodationDTO accommodationDTO, Accommodation accommodation) {
		assertEquals(accommodation.getAddress().getCity(), accommodationDTO.getAddressCity());
		assertEquals(accommodation.getAddress().getStreet(), accommodationDTO.getAddressStreet());
		assertEquals(accommodation.getNumber(), accommodationDTO.getNumber());
		assertEquals(accommodation.getAddress().getState(), accommodationDTO.getAddressState());
		assertEquals(accommodation.getAddress().getZipCode(), accommodationDTO.getAddressZipCode());
		
		}

}
