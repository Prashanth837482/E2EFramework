package javaCoding;

import org.testng.annotations.Test;

public class LengthOfLastWord {
	
	@Test()
	public void LengthOfLastWordInString() {
		String input = "   fly me   to   the moon  ";
		input = input.strip();
		String[] words = input.split(" ");
		System.out.println(words[words.length-1].length());
	}
	

}
