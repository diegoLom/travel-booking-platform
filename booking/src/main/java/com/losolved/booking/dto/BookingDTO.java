package com.losolved.booking.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
	
	  private Long id;
	private Integer accommodationId;
	private Integer flightId;
	private Integer guest;
	private LocalDateTime bookingDate;
	private double totalAmount;

}
