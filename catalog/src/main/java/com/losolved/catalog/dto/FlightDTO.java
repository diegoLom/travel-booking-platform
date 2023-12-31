package com.losolved.catalog.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FlightDTO {
	
	private Integer number;
	private LocalDateTime departure; 
	private LocalDateTime arrival; 
    private String streetArrival;
    private String cityArrival;
    private String stateArrival;
    private String zipCodeArrival;
    private String streetDeparture;
    private String cityDeparture;
    private String stateDeparture;
    private String zipCodeDeparture;
    private String companyName;
    private String companyDetails;


}
