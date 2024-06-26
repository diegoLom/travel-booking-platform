package com.losolved.catalog.model;

import jakarta.persistence.Embedded;
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
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false) 
    @JoinColumn(name="departure_id", nullable=false, updatable=false)
    private Address departure;
    
    @ManyToOne(optional=false) 
    @JoinColumn(name="arrival_id", nullable=false, updatable=false)
    private Address arrival;
    
}