package com.losolved.user.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysql.cj.jdbc.JdbcConnection;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	private  JdbcConnection  mockDbConnection;
	
	@BeforeAll
	public void setUp() {
		
		mockDbConnection = mock(JdbcConnection.class);
		userRepository = new UserRepository(mockDbConnection);
		
	}
	
	
	   @Test
	    public void testFindUserById() {
	        // Define the behavior of the mock database connection
	        when(mockDbConnection.createStatement().executeQuery("SELECT * FROM users WHERE id = 1"))
	            .thenReturn(null/* Mocked user data */);

	        // Test the findUserById method
	        User user = userRepository.findUserById(1);
	        assertEquals("John Doe", user.getName());
	    }
	
}
