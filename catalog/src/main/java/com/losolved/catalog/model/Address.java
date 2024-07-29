package com.losolved.catalog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Address extends BaseEntity  {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    
    @Column(name = "zipcode")
    private String zipCode;

    // Constructors, getters, setters
}