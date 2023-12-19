package com.losolved.catalog.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseEntityTest {
	
	private static BaseEntity baseEntity; 
	
	@BeforeAll
	private static void setup() {
		baseEntity = new BaseEntity();
	}
	
	
	@Test
	public void createdAtValidation() {
		final LocalDateTime now = LocalDateTime.now();
		baseEntity.setCreatedAt(now); 
		assertEquals(baseEntity.getCreatedAt(), now);
	}
	
	@Test
	public void createdByValidation() {
		final String author = "Diego Santos";
		baseEntity.setCreatedBy(author);
		assertEquals(author, baseEntity.getCreatedBy());
	}
	
	@Test
	public void updatedAtValidation() {
		final LocalDateTime now = LocalDateTime.now();
		baseEntity.setUpdatedAt(now); 
		assertEquals(baseEntity.getUpdatedAt(), now);
	}
	
	@Test
	public void updatedByValidation() {
		final String author = "Diego Santos";
		baseEntity.setUpdatedBy(author);
		assertEquals(author, baseEntity.getUpdatedBy());
	}
	
	

}
