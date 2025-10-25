package javaCoding;

import org.testng.annotations.Test;

public class StringCompression {

	
	@Test
	public void StringCompression() {
		//(e.g. "aabcccccaaa"  "a2b1c5a3")
		//String text = "aabcccccaaa";
		String text = "adbcccccaab";
		int counter=1;
		for(int i=0; i<text.length()-1; i++) {
			//char currentChar = text.charAt(i);
			
			if(text.charAt(i) == text.charAt(i+1)) {
				counter++;
				
			}			
			else{
				System.out.print(text.charAt(i));
				System.out.print(counter);
				//currentChar = text.charAt(i+1);
				counter = 1;
				
			}
		}
		System.out.print(text.charAt(text.length()-1));
		System.out.println(counter);
	}
	
	@Test
	public void StringCompression2() {
		//(e.g. "aabcccccaaa"  "a2b1c5a3")
		//String text = "aabcccccaaa";
		String text = "adbcccccaab";
		StringBuilder result = new StringBuilder();
	    int count = 1;

	    for (int i = 1; i < text.length(); i++) {
	        if (text.charAt(i) == text.charAt(i - 1)) {
	            count++;
	        } else {
	            result.append(text.charAt(i - 1)).append(count);
	            count = 1; // reset counter
	        }
	    }

	    // append the last character and its count
	    result.append(text.charAt(text.length() - 1)).append(count);

	    System.out.println(result.toString());
	}
}
