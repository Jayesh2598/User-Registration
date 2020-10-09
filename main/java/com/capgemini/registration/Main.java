package com.capgemini.registration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
interface Validate {
	public boolean validateUserDetails(String userDetails);
}

public class Main {
	
	static Scanner SC=new Scanner(System.in);
	
	public static final String firstNamePattern= "^[A-Z][a-z]{2,}";
	public static final String lastNamePattern= "^[A-Z][a-z]{2,}";
	public static final String emailPattern= "^[a-zA-Z][a-zA-Z0-9_+-]{2,}([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9]+[.][a-zA-Z]{2,}([.][a-zA-Z]{2,})?$";
	public static final String phNoPattern= "[0-9]{1,2}[' '][7-9][0-9]{9}";
	public static final String passwordPattern= "[[*&^%$#@!`.,?:;]{1}(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9_]]{8,}";
	
	public static void main(String[] args) throws InvalidUserDetailsException {
		System.out.println("Welcome to User Registration!\n");
		
		try {
			String fName = takeInput("First Name");
			Validate validateFirstName = (firstname) -> validate(fName,firstNamePattern);
			if(validateFirstName.validateUserDetails(fName))
				System.out.println("First Name is valid!\n");
			else
				throw new InvalidUserDetailsException("First Name is invalid.\n");
		} catch (InvalidUserDetailsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String lName = takeInput("Last Name");
			Validate validateLastName = (lastname) -> validate(lName,lastNamePattern);
			if(validateLastName.validateUserDetails(lName))
				System.out.println("Last Name is valid!\n");
			else
				throw new InvalidUserDetailsException("Last Name is invalid.\n");
		} catch (InvalidUserDetailsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String email = takeInput("Email");
			Validate validateEmail = (Email) -> validate(email,emailPattern);
			if(validateEmail.validateUserDetails(email))
				System.out.println("Email is valid!\n");
			else
				throw new InvalidUserDetailsException("Email is invalid.\n");
		} catch (InvalidUserDetailsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String phNo = takeInput("Mobile Number");
			Validate validatePhoneNumber = (PhNo) -> validate(phNo,phNoPattern);
			if(validatePhoneNumber.validateUserDetails(phNo))
				System.out.println("Mobile number is valid!\n");
			else
				throw new InvalidUserDetailsException("Mobile number is invalid.\n");
		} catch (InvalidUserDetailsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String password = takeInput("Password");
			Validate validatePassword = (pwd) -> validate(password,passwordPattern);
			if(validatePassword.validateUserDetails(password))
				System.out.println("Password is valid!\n");
			else
				throw new InvalidUserDetailsException("Password is invalid.\n");
		} catch (InvalidUserDetailsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String takeInput(String fieldName) {
		System.out.println("Enter the "+fieldName);
		return SC.nextLine();
	}
	
	public static boolean validate(String field, String pattern) {	
		Pattern patternObj= Pattern.compile(pattern);
		Matcher matcherObj= patternObj.matcher(field);
		if(matcherObj.matches())
			return true;
		else
			return false;
	}
}
