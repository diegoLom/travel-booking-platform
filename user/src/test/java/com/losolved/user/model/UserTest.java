package com.losolved.user.model;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.losolved.user.exceptions.EmailInvalidException;
import com.losolved.user.exceptions.PasswordInvalidException;

@SpringBootTest
//Each class should have a test Class 
public class UserTest {
	
	private static User user;
	
	@BeforeAll
	private static void setup() {
		user = User.builder().build();
	}
	
	
	@Test
	public void request() {
		assertEquals("diego", "diego");
		
	}
	//Write the test before the class implementation 
	
	@Test
	public void userWithInvalidEmail() {
		 Assertions.assertThrows(EmailInvalidException.class , () -> user.setEmail("invalid_Email"));
	}
	
	@Test
	public void userWithInvalidPassword() {
		Assertions.assertThrows(PasswordInvalidException.class, () -> user.setPassword("wrong_password")); 
	}
	
	
	
  //model class  set / methods

}
