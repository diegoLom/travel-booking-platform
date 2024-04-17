package com.losolved.catalog.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;

import com.losolved.catalog.dto.AccommodationDTO;
import com.losolved.catalog.dto.ResponseDTO;
import com.losolved.catalog.dto.filter.InLocationAndPriceBetween;
import com.losolved.catalog.errorhandling.NoSuchAccommodationException;
import com.losolved.catalog.model.Accommodation;
import com.losolved.catalog.model.Address;
import com.losolved.catalog.repositories.AccommodationRepository;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

@SpringBootTest
public class AccommodationServiceTest {

	private AccommodationService accommodationService;

	@MockBean
	private AccommodationRepository accommodationRepository;

	
	@Autowired
	public AccommodationServiceTest(AccommodationService accommodationService) {
		this.accommodationService = accommodationService;
	}

	public void testArrange() {
		Accommodation mockedAccommodation = MockedCatalog.getAccommodation();
		AccommodationDTO accommodationDTO = accommodationService.getAccommodationMapper()
				.convertEntityToDTO(mockedAccommodation);

		given(accommodationRepository.save(ArgumentMatchers.any())).willReturn(Optional.of(mockedAccommodation));

		ResponseDTO response = accommodationService.arrange(accommodationDTO);
		assertEquals(response.getCode(), HttpStatus.CREATED.value());
		assertEquals(response.getMessage(), "Accommodation set up");
	}

	@Test
	public void testRetrieveAccommodationById() {
		Accommodation mockedAccommodation = MockedCatalog.getAccommodation();
		given(accommodationRepository.findById(anyLong())).willReturn(Optional.of(mockedAccommodation));

		Accommodation retrievedAccommodation = accommodationService.getAccommodation(anyLong());

		assertEquals(mockedAccommodation.getId(), retrievedAccommodation.getId());
		assertEquals(mockedAccommodation.getAddress(), retrievedAccommodation.getAddress());
		assertEquals(mockedAccommodation.getPrice(), retrievedAccommodation.getPrice());
		assertEquals(mockedAccommodation.getDetail(), retrievedAccommodation.getDetail());
	}

	@Test
	public void testRetrieveAccommodationByIdNotFound() {
		given(accommodationRepository.findById(anyLong())).willReturn(Optional.empty());

		assertThrows(NoSuchAccommodationException.class, () -> accommodationService.getAccommodation(anyLong()));
	}

	@Test
	public void testRetrieveAccommodationByAddressAndPriceRange() {
		List<Accommodation> allAccommodations = MockedCatalog.getAccommodations();

		Double startPrice = 100.00;
		Double endPrice = 200.00;

		Address address = Address.builder().city(MockedCatalog.CAMACARI).state("Bahia").street("Gleba C")
				.zipCode("428234323").build();

		InLocationAndPriceBetween inLocationAndPriceBetween = new InLocationAndPriceBetween(address, startPrice,
				endPrice);

		List<Accommodation> accommodationsFiltered = allAccommodations.stream()
				.filter(a -> a.getAddress().getCity().equals(inLocationAndPriceBetween.address().getCity())
						&& a.getPrice().compareTo(startPrice) >= 0 && a.getPrice().compareTo(endPrice) <= 0)
				.collect(Collectors.toList());

		given(accommodationRepository.findByAddressAndPriceBetween(any(Address.class), anyDouble(), anyDouble()))
				.willReturn(accommodationsFiltered);

		List<Accommodation> retrievedAccommodations = accommodationService.getAccommodation(inLocationAndPriceBetween);

		assertEquals(accommodationsFiltered.size(), retrievedAccommodations.size());
	}
	
	
	@Test
	public void testRetrieveAccommodationByAddressAndPriceNotFound() {
		given(accommodationRepository.findByAddressAndPriceBetween(ArgumentMatchers.any(), ArgumentMatchers.anyDouble(), ArgumentMatchers.anyDouble())).
				willReturn(Collections.emptyList());

		assertThrows(NoSuchAccommodationException.class, () -> accommodationService.getAccommodation(new InLocationAndPriceBetween(ArgumentMatchers.any(),
				ArgumentMatchers.anyDouble(),
				ArgumentMatchers.anyDouble())));
	}
	
	@Test
	public void testSuccessUpdateAccommodation() {
		Accommodation accommodation = MockedCatalog.getAccommodation();
		accommodation.setId(1L);
		given(accommodationRepository.save(any())).willReturn(accommodation);
		
		AccommodationDTO dto = accommodationService.getAccommodationMapper().convertEntityToDTO(accommodation);
		
		ResponseDTO responseDTO = accommodationService.update(dto);

		assertEquals(HttpStatus.OK.value(), responseDTO.getCode());
		assertEquals("Accommodation updated", responseDTO.getMessage());
	}


	@Test
	public void testFailureUpdateAccommodation() {
		Accommodation accommodation = new Accommodation();
		accommodation.setId(3L);
		given(accommodationRepository.save(accommodation)).willThrow(OptimisticLockingFailureException.class);
		
		AccommodationDTO dto = accommodationService.getAccommodationMapper().convertEntityToDTO(accommodation);

		assertThrows(NoSuchAccommodationException.class, () -> accommodationService.update(dto));
	}


	@Test
	public void testFailureRetrieveBook() {
		given(accommodationRepository.findById(anyLong())).willReturn(Optional.empty());

		assertThrows(NoSuchAccommodationException.class, () -> accommodationService.getAccommodation(anyLong()));
	}

	@Test
	public void testSuccessRetrieveAccommodation() {
		Accommodation mockedAccommodation = MockedCatalog.getAccommodation();
		given(accommodationRepository.findById(anyLong())).willReturn(Optional.of(mockedAccommodation));

		Accommodation retrievedAccommodation = accommodationService.getAccommodation(anyLong());

		assertEquals(mockedAccommodation.getId(), retrievedAccommodation.getId());
		assertEquals(mockedAccommodation.getAddress(), retrievedAccommodation.getAddress());
		assertEquals(mockedAccommodation.getPrice(), retrievedAccommodation.getPrice());
		assertEquals(mockedAccommodation.getDetail(), retrievedAccommodation.getDetail());
	}

	// Helper methods to create mocked data

}