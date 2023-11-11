package com.losolved.user.patterns;

public enum RegularExpression {
	
	
	
	EMAIL("^(.+)@(\\S+)$"), 
	PASSWORD("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$");
	
	private String value;

	
	RegularExpression( String value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return value;
	} 
	
	
	
	
	

}
