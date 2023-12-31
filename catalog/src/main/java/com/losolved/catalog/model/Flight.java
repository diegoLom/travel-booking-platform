package com.losolved.catalog.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class Flight extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer number;
	
	private LocalDateTime departure; 
	
	private LocalDateTime arrival; 
	
	@ManyToOne(optional=false) 
    @JoinColumn(name="arrival_id", nullable=false, updatable=false)
	private Route route;
	

}
//TODO: Look at Embeddable 