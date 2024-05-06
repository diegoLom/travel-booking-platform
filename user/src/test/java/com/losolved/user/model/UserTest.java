package com.losolved.user.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.context.SpringBootTest;

import com.losolved.user.patterns.RegularExpression;
import com.losolved.user.patterns.ValidationPattern;




/**
Now, it's widely recognized that certain classes, such as simple models,
 may not require dedicated test classes. This is particularly true in the case of the
 User class in question, as it lascks significant functionality.
 just having set and get methods that are generally created by IDE. Another example is JPARepository class.
 */
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
		user.setEmail("wrong_email");
		Assertions.assertFalse(ValidationPattern.matches(user.getEmail(), RegularExpression.EMAIL.toString()), 
				"Invalid email was informed ");
	}
	
	@Test
	public void userWithInvalidPassword() {
		user.setPassword("wrong_password");
		Assertions.assertFalse(ValidationPattern.matches(user.getPassword(), RegularExpression.PASSWORD.toString()), 
				"Invalid password was informed");
	}
	
	
	
  //model class  set / methods

}
