package javaCoding;

import java.util.Arrays;

import org.testng.annotations.Test;

public class LongestStringNumber {
	
	@Test
	public void longestStringNumber() {
		int[] inputs = {5,6,1};
		String stringNumber="";
		for(int num : inputs) {
			stringNumber =stringNumber+ String.valueOf(num);
		}
		char[] charArray = stringNumber.toCharArray();
		Arrays.sort(charArray);
		StringBuilder sb = new StringBuilder(new String(charArray));
		System.out.println(sb.reverse());
		
	}

}
