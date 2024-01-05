package com.losolved.booking;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.losolved.booking.dto.ModelMapperConfig;

@SpringBootTest
@SpringJUnitConfig(classes = ModelMapperConfig.class)
class BookingApplicationTests {

	@Test
	void contextLoads() {
	}
	

}
