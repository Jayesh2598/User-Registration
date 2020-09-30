package com.capgemini.registration;

import java.util.Scanner;

public class Main {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to User Registration!");
		
		System.out.println("Enter the first name:");
		String firstName = sc.nextLine().trim();
		
		if(firstName.matches("^[A-Z][a-z]{2,}")) 
			System.out.println("First Name is valid.");
		else
			System.out.println("First Name is invalid.");
	}

}
