package com.losolved.catalog.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.losolved.catalog.dto.filter.InDateBetweenAndRoute;
import com.losolved.catalog.dto.filter.InLocationAndPriceBetween;
import com.losolved.catalog.model.Accommodation;
import com.losolved.catalog.model.Address;
import com.losolved.catalog.model.Airline;
import com.losolved.catalog.model.Flight;
import com.losolved.catalog.model.Route;

public class MockedCatalog {

	public static List<Flight> getFlights() {
		LocalDateTime departureInFive = LocalDateTime.now().plusDays(5);
		LocalDateTime departureInFour = LocalDateTime.now().plusDays(4);
		LocalDateTime departureInThree = LocalDateTime.now().plusDays(3);

		Flight fromCamacariToLondonThreeDays = Flight.builder().departure(departureInThree)
				.route(fromCamacariToLondon()).build();
		Flight fromCamacariToLondonFourDays = Flight.builder().departure(departureInFour).route(fromCamacariToLondon())
				.build();
		Flight fromCamacariToLondonFiveDays = Flight.builder().departure(departureInFive).route(fromCamacariToLondon())
				.build();

		Flight fromSaoPauloToLondonThreeDays = Flight.builder().departure(departureInThree)
				.route(fromSaoPauloToLondon()).build();
		Flight fromSaoPauloToLondonFourDays = Flight.builder().departure(departureInFour).route(fromSaoPauloToLondon())
				.build();
		Flight fromSaoPauloToLondonFiveDays = Flight.builder().departure(departureInFive).route(fromSaoPauloToLondon())
				.build();

		return Stream
				.of(fromCamacariToLondonFiveDays, fromCamacariToLondonFourDays, fromCamacariToLondonThreeDays,
						fromSaoPauloToLondonFiveDays, fromSaoPauloToLondonFourDays, fromSaoPauloToLondonThreeDays)
				.collect(Collectors.toList());
	}

	public static List<Flight> getFlightFiltered() {
		LocalDateTime departureInFive = LocalDateTime.now().plusDays(5);
		LocalDateTime departureInFour = LocalDateTime.now().plusDays(4);

		InDateBetweenAndRoute searchFilter = new InDateBetweenAndRoute(departureInFour, departureInFive,
				MockedCatalog.fromCamacariToLondon());

		List<Flight> filteredFlight = getFlights().stream()
				.filter(x -> x.getDeparture().compareTo(searchFilter.starDeparture()) >= 0
						&& x.getDeparture().compareTo(searchFilter.endDeparture()) <= 0
						&& x.getRoute().equals(searchFilter.route()))
				.collect(Collectors.toList());

		return filteredFlight;
	}

	public static final String CAMACARI = "Camaçari";
	public static final String LONDON = "London";
	public static final String SAOPAULO = "São Paulo";

	// TODO: Add airport in data modeling
	public static Route fromCamacariToLondon() {
		Address addressDeparture = Address.builder().city(CAMACARI).build();
		Address addressArrival = Address.builder().city(LONDON).build();

		Route route = Route.builder().arrival(addressArrival).departure(addressDeparture).build();
		return route;
	}

	public static Route fromSaoPauloToLondon() {
		Address addressDeparture = Address.builder().city(SAOPAULO).build();
		Address addressArrival = Address.builder().city(LONDON).build();

		Route route = Route.builder().arrival(addressArrival).departure(addressDeparture).build();
		return route;
	}

	public static Flight getMockedFlight() {
		LocalDateTime departure = LocalDateTime.now().plusDays(5);
		LocalDateTime arrival = LocalDateTime.now().plusHours(8);

		Address addressDeparture = Address.builder().city(CAMACARI).state("Bahia").street("Rua Décima do Parque")
				.zipCode("42802323").build();
		Address addressArrival = Address.builder().city(SAOPAULO).state("Osasco").street("Marechal")
				.zipCode("428234323").build();

		Route route = Route.builder().arrival(addressArrival).departure(addressDeparture).build();
		Airline airline = Airline.builder().companyDetails("LINHAS AERES").companyName("GOL").build();

		Flight flight = Flight.builder().number(92).route(route).arrival(arrival).departure(departure).airline(airline)
				.build();

		return flight;
	}

	public static Accommodation getAccommodation() {
		Address camacari_hotel = Address.builder().city(CAMACARI).state("Bahia").street("Gleba C").zipCode("428234323")
				.build();

		Accommodation accommodation_basic_camacari = Accommodation.builder().address(camacari_hotel).price(100.00)
				.detail("Basic accommodation camacari").build();

		return accommodation_basic_camacari;
	}

	public static List<Accommodation> getAccommodations() {
		Address saopaulo_hotel = Address.builder().city(SAOPAULO).state("Bahia").street("Rio Vermelho")
				.zipCode("428234318").build();

		Address camacari_hotel = Address.builder().city(CAMACARI).state("Bahia").street("Gleba C").zipCode("428234323")
				.build();

		Accommodation accommodation_basic_camacari = Accommodation.builder().address(camacari_hotel).price(100.00)
				.detail("Basic accommodation camacari").build();
		Accommodation accommodation_soft_camacari = Accommodation.builder().address(camacari_hotel).price(200.00)
				.detail("Soft accommodation camacari").build();
		Accommodation accommodation_premium_camacari = Accommodation.builder().address(camacari_hotel).price(300.00)
				.detail("Premium accommodation camacari").build();

		Accommodation accommodation_basic_saopaulo = Accommodation.builder().address(saopaulo_hotel).price(200.00)
				.detail("Basic accommodation salvador").build();
		Accommodation accommodation_soft_saopaulo = Accommodation.builder().address(saopaulo_hotel).price(300.00)
				.detail("Soft accommodation salvador").build();
		Accommodation accommodation_premium_saopaulo = Accommodation.builder().address(saopaulo_hotel).price(400.00)
				.detail("Premium accommodation salvador").build();

		List<Accommodation> accommodations = new ArrayList<>();

		accommodations.add(accommodation_basic_camacari);
		accommodations.add(accommodation_soft_camacari);
		accommodations.add(accommodation_premium_camacari);
		accommodations.add(accommodation_basic_saopaulo);
		accommodations.add(accommodation_soft_saopaulo);
		accommodations.add(accommodation_premium_saopaulo);

		return accommodations;
	}

	public static List<Accommodation> getAccommodationsFiltered() {

		Double startPrice = 100.00;
		Double endPrice = 200.00;

		Address address = Address.builder().city(MockedCatalog.CAMACARI).state("Bahia").street("Gleba C")
				.zipCode("428234323").build();

		InLocationAndPriceBetween inLocationAndPriceBetween = new InLocationAndPriceBetween(address, startPrice,
				endPrice);

		List<Accommodation> accommodationsFiltered = getAccommodations().stream()
				.filter(a -> a.getAddress().getCity().equals(inLocationAndPriceBetween.address().getCity())
						&& a.getPrice().compareTo(startPrice) >= 0 && a.getPrice().compareTo(endPrice) <= 0)
				.collect(Collectors.toList());

		return accommodationsFiltered;

	}

	

}
