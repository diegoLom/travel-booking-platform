package com.losolved.user.patterns;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidationPatternTest {
	
	@Test
	public void testSimpleREgexEmail() {
		String emailAddress = "diegosantana@gmail.com";
		assertTrue(ValidationPattern.patternMatches(emailAddress, RegularExpression.EMAIL.toString())); 
	}

}
