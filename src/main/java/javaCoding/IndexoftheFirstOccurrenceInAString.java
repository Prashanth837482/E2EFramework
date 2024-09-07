package javaCoding;

import org.testng.annotations.Test;

public class IndexoftheFirstOccurrenceInAString {
	
	
	// LeetCode Question : https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=problem-list-v2&envId=string
	@Test()
	public void testing() {
		
		String input = "sadbutsad";
		String searchString = "sad";
		
		if (input.contains(searchString)) {
			
			// indexOf method returns index with in the string for first occurance match.			
			System.out.println(input.indexOf(searchString));
			
			// LastIndexOf method returns index with in the string for last occurance match.
			//input.lastIndexOf(searchString);
		}
		else {
			System.out.println(-1);
			
		}
	}

}
