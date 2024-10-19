package javaCoding;

import org.testng.annotations.Test;

public class Pangram {

	
	@Test
	public void pangram() {
		String input ="The quick brown fox jumps over the lazy dog";
		input = input.toLowerCase(); // to convert string to lower case as we are checking only for lower case chars
		boolean[] arr = new boolean[26];
		boolean isPangram = true;
		for(char ch : input.toCharArray()){
			
			if(ch>='a' && ch<='z') {
				arr[ch-'a'] = true;
			}
		}
		
		for(boolean flag : arr) {
			if(!flag) {
				
				isPangram = false;
				break;
			}
		}
		
		if(isPangram) {
			System.out.println("Input string is a pangram");
		}
		else {
			System.out.println("Input string is not a pangram");
		}
		
	}
}
