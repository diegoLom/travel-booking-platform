package com.losolved.catalog.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class FlightDTO {
	
	private Long id;
	private Integer number;
	private LocalDateTime departure; 
	private LocalDateTime arrival;
	private Long airlineId;
	private Long routeId;
    
	private Long routeDepartureId;
    private String routeDepartureStreet; 
    private String routeDepartureCity;
    private String routeDepartureState;
    private String routeDepartureZipCode;
	private Long routeArrivalId;
    private String routeArrivalStreet;
    private String routeArrivalCity;
    private String routeArrivalState;
    private String routeArrivalZipCode;
    private String airlineCompanyName;
    private String airlineCompanyDetails;
    
    


}
