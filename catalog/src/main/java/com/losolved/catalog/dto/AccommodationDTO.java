package com.losolved.catalog.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccommodationDTO {

	private Integer number;
	private String street;
	private String city;
    private String state;
    private String zipCode;


}
