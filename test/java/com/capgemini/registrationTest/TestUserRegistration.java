package com.capgemini.registrationTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.capgemini.registration.Main;

public class TestUserRegistration {
	
	@Test
	//Happy Test
	public void HappyTests() {
		boolean expectedFirstName= true;
		boolean actualFirstName= Main.validate("Jayesh", Main.firstNamePattern);
		assertEquals(expectedFirstName, actualFirstName);
		
		boolean expectedLastName= true;
		boolean actualLastName= Main.validate("Chaudhari", Main.lastNamePattern);
		assertEquals(expectedLastName, actualLastName);
		
		boolean expectedEmail= true;
		boolean actualEmail= Main.validate("Jayesh2598@gmail.com", Main.emailPattern);
		assertEquals(expectedEmail, actualEmail);
		
		boolean expectedPhoneNo= true;
		boolean actualPhoneNo= Main.validate("91 7045279233", Main.phNoPattern);
		assertEquals(expectedPhoneNo, actualPhoneNo);
		
		boolean expectedPassword= true;
		boolean actualPassword= Main.validate("!Jay2598", Main.passwordPattern);
		assertEquals(expectedPassword, actualPassword);
	}
	
	//Sad Test
	public void SadTests() {
		boolean expectedFirstName= false;
		boolean actualFirstName= Main.validate("jayesh", Main.firstNamePattern);
		assertEquals(expectedFirstName, actualFirstName);
		
		boolean expectedLastName= false;
		boolean actualLastName= Main.validate("chaudhari", Main.lastNamePattern);
		assertEquals(expectedLastName, actualLastName);
		
		boolean expectedEmail= false;
		boolean actualEmail= Main.validate("Jayesh2598@gmail@gmail.com", Main.emailPattern);
		assertEquals(expectedEmail, actualEmail);
		
		boolean expectedPhoneNo= false;
		boolean actualPhoneNo= Main.validate("917045279233", Main.phNoPattern);
		assertEquals(expectedPhoneNo, actualPhoneNo);
		
		boolean expectedPassword= false;
		boolean actualPassword= Main.validate("!@Jay2598", Main.passwordPattern);
		assertEquals(expectedPassword, actualPassword);
	}
	
}
