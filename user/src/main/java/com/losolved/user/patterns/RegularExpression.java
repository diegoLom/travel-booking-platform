package com.losolved.user.patterns;

public enum RegularExpression {
	
	
	
	EMAIL("^(.+)@(\\S+)$");
	
	private String value;

	
	RegularExpression( String value) {
		this.value = value;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	} 
	
	
	
	
	

}
