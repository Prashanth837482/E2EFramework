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
	
	//https://chatgpt.com/c/68ff9ac2-4504-8322-89c8-8b8e6dc27c75
	// Function to find the longest common prefix: first gets the longest prefix between adjacent elements and compares that common prefix with next element and so on
    public String findLongestCommonPrefix(String[] strs) {
        // Edge case: empty array
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as prefix
        String prefix = strs[0];

        // Compare with every other string
        for (int i = 1; i < strs.length; i++) {
            // Reduce prefix until it matches
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // If prefix becomes empty, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
    
    public static void main(String args[]) {
    	coomonSuffix obj = new coomonSuffix();
    	String[] words = {"apple", "application", "apt"};
    	System.out.println(obj.findLongestCommonPrefix(words));
    }

}
