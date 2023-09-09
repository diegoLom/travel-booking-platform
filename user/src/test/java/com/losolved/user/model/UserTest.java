package com.losolved.user.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.contains;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//Each class should have a test Class 
public class UserTest {
	
	private User user;
	
	@BeforeAll
	private void setup() {
		user = new User();
	}
	
	
	@Test
	public void request() {
		assertEquals("diego", "diego");
		
	}
	//Write the test before the class implementation 
	
	@Test(expected = EmailInvalidException.class)
	public void testUserEmailThatThrowsException() {
		user.setEmail("invalid_Email");
	}
	
	@Test(expected = PasswordInvalidException.class)
	public void testUserPassword() {
		user.setPassword("12345"); 	
	}
	

}
