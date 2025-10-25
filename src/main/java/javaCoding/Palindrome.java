package javaCoding;

import org.testng.annotations.Test;

public class Palindrome {
	
	@Test
	public void palindromeCheck() {
		String word  = "Madam";
		word = word.toLowerCase();
		int length  = word.length();
		boolean isPalindrome = true;
		for(int i=0; i<length/2; i++) {
			if(!(word.charAt(i)==word.charAt(length-1-i))) {
				isPalindrome = false;
			}
		}
		
		if(isPalindrome) {
			System.out.println("Given word: "+ word +" is palindrome");
		}
		else {
			System.out.println("Given word: "+ word +" is not palindrome");
		}
	}

}
