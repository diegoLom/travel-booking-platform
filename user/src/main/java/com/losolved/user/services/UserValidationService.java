package com.losolved.user.services;

import java.util.Optional;

import com.losolved.user.exceptions.DuplicateUserNameException;
import com.losolved.user.exceptions.EmailInvalidException;
import com.losolved.user.exceptions.PasswordInvalidException;
import com.losolved.user.model.User;
import com.losolved.user.patterns.RegularExpression;
import com.losolved.user.patterns.ValidationPattern;
import com.losolved.user.repositories.UserRepository;

import lombok.Data;


public class UserValidationService {

	
    public static  void validateUserName(boolean existUserWithSameName){
    	if(existUserWithSameName){
		    throw new DuplicateUserNameException();
		}
    }

    public static void validateEmail(User user){
    	if(!ValidationPattern.matches(user.getEmail(), RegularExpression.EMAIL.toString()))
    		throw new EmailInvalidException();
    }

    public static void validatePassword(User user){
       	if(!ValidationPattern.matches(user.getEmail(), RegularExpression.EMAIL.toString()))
       		throw new PasswordInvalidException();
    }

  


}
