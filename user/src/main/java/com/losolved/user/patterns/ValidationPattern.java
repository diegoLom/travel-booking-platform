package com.losolved.user.patterns;

import java.util.regex.Pattern;

public class ValidationPattern {

	public static boolean patternMatches(String field, String regex) {
		 return Pattern.compile(regex)
			      .matcher(field).matches(); 

	}

}
