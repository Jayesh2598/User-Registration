package com.capgemini.registrationTest;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.capgemini.registration.Main;

@RunWith(Parameterized.class)
public class MultipleEntries {
	
	String input;
	boolean output;
	
	public MultipleEntries(String input, boolean output) {
		this.input = input;
		this.output = output;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> inputEmailSamples() {
		return Arrays.asList(new Object[][] {{"abc@yahoo.com",true},{"abc.100@abc.com.au",true},{"abc@1.com",true},{"abc123@gmail.1a",false},{"abc@gmail@gmail.com",false},{"abc@gmail.com.aa.au",false}});
	}
	
	@Test
	public void MultipleEntryTest() {
		System.out.println("Input: "+input);
		assertEquals(output, Main.validate(input, Main.emailPattern));		
	}
}
