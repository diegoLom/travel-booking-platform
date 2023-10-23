package com.losolved.user.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.losolved.user.exceptions.EmailInvalidException;
import com.losolved.user.exceptions.PasswordInvalidException;
import com.losolved.user.patterns.RegularExpression;
import com.losolved.user.patterns.ValidationPattern;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
//Generates getters/setter for all fields , constructor, equals and toString for non-transient fields 
@Data
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", unique = true)
    private String userName;

    @Column(name = "email", unique = true)
    private String email;
   
    @Column(name = "password")
    private String password; 

    
    public void setEmail(String email) {
    	
    	if(ValidationPattern.patternMatches(email, RegularExpression.EMAIL.toString())) {
    		this.email = email;
    	}else {
    	 	throw new EmailInvalidException();
    	}
     }
    
    public void setPassword(String password) {
    	
    	if(ValidationPattern.patternMatches(password, RegularExpression.PASSWORD.toString())){
    		this.password = password;
    	}else {
    		throw new PasswordInvalidException();
    	}
    }
    
    
}
