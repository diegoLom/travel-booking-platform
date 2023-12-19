package com.losolved.booking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
	
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	@Column(updatable = false)
	private String createdBy;
	
	@Column(insertable  = false)
	private LocalDateTime updatedAt;
	
	@Column(insertable  = false)
	private String updatedBy;
	
}
