package javaCoding;

import org.testng.annotations.Test;

public class VowelsAndConsonants {
	
	@Test
	public void VowelsAndConsonantsMeth() {
		
		String input = "This code is to check vowels and consonants";
		int vowels= 0;
		int consonants = 0;
		
		// convert the string to lower/upper case as all chars should be one of the case so that our comparison check works in if block
		// store the converted string in to the same variable as string is immutable.
		input = input.toLowerCase();
		for(char ch: input.toCharArray()) {
			
			if(ch=='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				vowels++;
			}
			else {
				consonants++;
			}
			
		}
		
		// we can also get the consonants count directly here instead of giving else block.
		int consonantsCount = input.length()-vowels;
		System.out.println("number of vowels in the string is: "+vowels);
		System.out.println("number of consonants in the string is: "+consonants);
		System.out.println("number of consonants in the string is: "+ consonantsCount);
		
	}
	

}
