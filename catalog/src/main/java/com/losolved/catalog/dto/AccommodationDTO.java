package com.losolved.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //TODO: It's possible use Record too 
@Builder
@NoArgsConstructor @AllArgsConstructor
public class AccommodationDTO {

	private Integer number;
	private String addressStreet;
	private String addressCity;
    private String addressState;
    private String addressZipCode;


}
