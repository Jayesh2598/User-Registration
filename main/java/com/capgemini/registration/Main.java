package com.capgemini.registration;

import java.util.Scanner;

public class Main {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to User Registration!");
		
		validate("First Name","^[A-Z][a-z]{2,}");
		validate("Last Name", "^[A-Z][a-z]{2,}");
		validate("Email","(^[a-zA-Z][a-zA-Z0-9_]{2,})([.+-][a-zA-Z0-9]{1,})?@([a-zA-Z0-9]{1,}).[a-zA-Z]{2,}(.[a-zA-Z]{2,})$");
		validate("Mobile number","[0-9]{1,2}[' '][7-9][0-9]{9}");
		validate("Password","(?=.*[A-Z]).{8,}");
		System.out.println("Registration successful!");
	}
			
	public static void validate(String fieldName, String pattern) {
		boolean loop=true;
		while(loop) {
			System.out.println("Enter the "+fieldName+":");
			String field = sc.nextLine().trim();	
			if(field.matches(pattern)) {
				System.out.println(":) "+fieldName+" is valid! (:");
				loop= false;
			}
			else
				System.out.println(":( "+fieldName+" is invalid. ):");
		}
	}
}
