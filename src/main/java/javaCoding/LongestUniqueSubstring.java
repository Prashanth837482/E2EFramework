package javaCoding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class LongestUniqueSubstring {
	
	// https://chatgpt.com/c/68fbb003-a0b4-8320-b81e-9191bed5fd4e -> for explanation
	
	@Test
	public void longestUniqueSubstring() {
		 String str = "abcabcbb";
		 int left = 0;
		 int right = 0;
		 int startIndextOfMaxLen = 0;
		 int maxLength = 0;
		 Set<Character> window = new HashSet<>();
		 
		 while(right<str.length()) {
			 
			 char currentChar = str.charAt(right);
			 
			// If duplicate char found, shrink from left until duplicated string removed from window
			 while(window.contains(currentChar)) {
				window.remove(str.charAt(left));
				left++;
			 }
			 
			 
			// Check if current window is longest so far
			 if(right-left+1 > maxLength) {
				 maxLength = right-left+1;
				 startIndextOfMaxLen = left;
			 }
			 
			 // Add current char to window
			 window.add(currentChar);
			 
			 right++;
		 }
		 System.out.println("Longest Unique Substring Length: "+maxLength);
		 System.out.println("Longest Unique Substring: "+str.substring(startIndextOfMaxLen,startIndextOfMaxLen+maxLength));
	}
	
	
	@Test
	public void longestUniqueSubstringForLoop() {
		 String str = "abcabcbb";
		 int left = 0;
		 //int right = 0;
		 int startIndextOfMaxLen = 0;
		 int maxLength = 0;
		 Set<Character> window = new HashSet<>();
		 
		 for(int right = 0; right<str.length(); right++) {
			 
			 char currentChar = str.charAt(right);
			 
			// If duplicate char found, shrink from left until duplicated string removed from window
			 while(window.contains(currentChar)) {
				window.remove(str.charAt(left));
				left++;
			 }
			 
			 
			// Check if current window is longest so far
			 if(right-left+1 > maxLength) {
				 maxLength = right-left+1;
				 startIndextOfMaxLen = left;
			 }
			 
			 // Add current char to window
			 window.add(currentChar);
			 
			 //right++;
		 }
		 
		 System.out.println("Longest Unique Substring Length using for loop: "+maxLength);
		 System.out.println("Longest Unique Substring using for loop: "+str.substring(startIndextOfMaxLen,startIndextOfMaxLen+maxLength));
	}
	
	

	@Test
	public void optimalApproachUsingMaps() {
		 String str = "abba";
		 int left = 0;
		 int right = 0;
		 int startIndextOfMaxLen = 0;
		 int maxLength = 0;
		 Map<Character, Integer> window = new HashMap<>();
		 
		 while(right<str.length()) {
			 
			 char currentChar = str.charAt(right);
			 
			// instead of moving left step-by-step (like in the set version), we jump directly to the correct index after the last duplicate without maintaining a window.
			 if(window.containsKey(currentChar)) {
				 // Math.Max to verify that we don't move left backward when a character with index lesser than left is found.
				left = Math.max(left, window.get(currentChar)+1);				
			 }
			 
			 
			// Check if current window is longest so far
			 if(right-left+1 > maxLength) {
				 maxLength = right-left+1;
				 startIndextOfMaxLen = left;
			 }
			 
			 // Add current char to window
			 window.put(currentChar,right);
			 
			 right++;
		 }
		 
		 System.out.println("Longest Unique Substring Length using Map: "+maxLength);
		 System.out.println("Longest Unique Substring using Map: "+str.substring(startIndextOfMaxLen,startIndextOfMaxLen+maxLength));
	}

}
