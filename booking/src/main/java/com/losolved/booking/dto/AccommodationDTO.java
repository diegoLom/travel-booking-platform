package com.losolved.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //TODO: It's possible use Record too 
@Builder
@NoArgsConstructor @AllArgsConstructor
public class AccommodationDTO {
	
	private Long id;
	private Integer number;
	private Integer addressId;
	private String addressStreet;
	private String addressCity;
    private String addressState;
    private String addressZipCode;
    private Double price; 
	private String detail;


}
