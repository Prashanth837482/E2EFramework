package javaCoding;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class AppleCodingQuestion {
	
	@Test
	public void rebuildMessage() {
		String brokenString = "*====# X-+-+-+-+-+-Z #___X A....*";
		String[] parts = brokenString.split(" ");
		Map<Character,String> startMap = new HashMap<Character, String>();
		
		for(String part: parts) {
			startMap.put(part.charAt(0), part);
			
		}
		System.out.println(startMap);
		
		
		String currentPart = startMap.get('A');
		StringBuffer result = new StringBuffer(currentPart);
		
		while(currentPart.charAt(currentPart.length()-1)!='Z') {
			currentPart = startMap.get(currentPart.charAt(currentPart.length()-1)); //BC
			result.append(currentPart.substring(1));
		}
		System.out.println(result);
	}
	// https://chatgpt.com/c/68fc9285-c4f0-8321-833a-9cf2053ff7c5
	@Test
	public void factorizeExtremities() {
		String str1 = "1234yyyabc";
		String str2 = "abcxxxx1234";
		int n1 = str1.length();
		int n2 = str2.length();
		
		int overlap1 = 0;
		for(int i =1; i<=Math.min(n1, n2);i++) {
			if(str1.substring(n1-i).equals(str2.subSequence(0, i))) {
				overlap1 = i;
			}
		}
		int overlap2 = 0;
		for(int i =1; i<=Math.min(n1, n2);i++) {
			if(str2.substring(n2-i).equals(str1.subSequence(0, i))) {
				overlap2 = i;
			}
		}
		
		if(overlap1>=overlap2) {
			System.out.println(str1+str2.substring(overlap1));
		}
		else {
			System.out.println(str2+str1.substring(overlap2));
		}
		
	}

}
