package com.losolved.catalog.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Flight extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //change dto and rename it for id like accommodation
	
	private Integer number;
	
	private LocalDateTime departure; 
	
	private LocalDateTime arrival; 
	
	@ManyToOne(optional=false) 
    @JoinColumn(name="arrival_id", nullable=false, updatable=false)
	private Route route;
	
	@ManyToOne(optional=false) 
    @JoinColumn(name="airline_id", nullable=false, updatable=false)
	private Airline airline;
	

}
//TODO: Look at Embeddable 