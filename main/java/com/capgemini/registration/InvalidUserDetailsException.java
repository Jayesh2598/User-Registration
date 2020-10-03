package com.capgemini.registration;

public class InvalidUserDetailsException extends Exception{
	
	public InvalidUserDetailsException (String msg) {
		super(msg);
	}
}
