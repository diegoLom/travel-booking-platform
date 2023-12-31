package com.losolved.booking.model;


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
public class Booking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne
    @JoinColumn(name = "accommodation_id")
    private Integer accommodationId;

    //@ManyToOne
    @JoinColumn(name = "flight_id")
    private Integer flightId;
    
    
    private Integer guest;
    
    private LocalDateTime bookingDate;
    
    private double totalAmount;

    // Other attributes, constructors, and methods

    // Getters and setters
}