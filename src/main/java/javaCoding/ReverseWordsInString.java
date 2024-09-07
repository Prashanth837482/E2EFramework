package javaCoding;

import org.testng.annotations.Test;

public class ReverseWordsInString {

	//Question: Reverse the order of the words. The returned string should only have a single space separating the words. Do not include any extra spaces.
	@Test()
	public void reverseWordsInString(){
		
		// input string with the leading and trailing spaces and multiple consecutive spaces in between the string
		String input = " prashanth is   a Techie ";
		
		
		// trim()/ strip() removes leading and trailing spaces.
		//replaceAll("\\s+", " ") replaces all consecutive spaces (indicated by the \\s+ regex) with a single space.
		input = input.strip().replaceAll("\\s+", " ");
		
		
		String[] words = input.split(" ");
		String reverseWordsString = "";
		for(int i =words.length-1; i>=0; i--) {
			
			reverseWordsString=reverseWordsString+" "+words[i];
			
			
		}
		
		System.out.println(reverseWordsString.strip());
		
	}
}
