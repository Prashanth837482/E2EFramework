package javaCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class coomonSuffix {

	@Test
	public void commonSuffixFunc() {
		String[] input = {"swimming","jumping","running"};
		
		Arrays.sort(input);
		String firstElement = input[0];
		String output ="";
		for(int i =1; i<=input[0].length();i++) {
			int count =1;
			for(int j=1; j<input.length; j++) {
				if(firstElement.charAt(firstElement.length()-i)==input[j].charAt(input[j].length()-i)) {
					count++;
				}
			}
			
			if(count == input.length) {
				System.out.println(firstElement.charAt(firstElement.length()-i));
				output = firstElement.charAt(firstElement.length()-i) + output;
			}
			else {
				break;
			}
			
		}
		System.out.println(output);
		
	}
}
