package com.losolved.booking.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookingFlightDTO {
	
	private BookingDTO bookingDTO;
	
	private FlightDTO flightDTO;

}
