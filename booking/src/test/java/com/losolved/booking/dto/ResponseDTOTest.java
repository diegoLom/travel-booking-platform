package com.losolved.booking.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResponseDTOTest {
	
	private static ResponseDTO responseDTO;
	
	@BeforeAll
	private static void setup() {
		responseDTO = ResponseDTO.builder().build();
	}
	
	@Test
	private void messageTest() {
		assertNull(responseDTO.getMessage());
		String message = "Successfull opertation";
		responseDTO.setMessage(message);
		assertEquals(message, responseDTO.getMessage());
	}
	
	@Test
	private void codeTest() {
		assertNull(responseDTO.getCode());
		Integer code =201; 
		responseDTO.setCode(code);
		assertEquals(code, responseDTO.getCode());
	}
}