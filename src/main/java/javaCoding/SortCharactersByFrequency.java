package javaCoding;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


import org.testng.annotations.Test;

public class SortCharactersByFrequency {

	@Test
	public void sortChars() {
		
		String input = "tree";
		
		Map<Character, Integer> freqOfChars = new TreeMap<>();
		
		for(char ch: input.toCharArray()) {
			freqOfChars.put(ch, freqOfChars.getOrDefault(ch, 0)+1);
		}
		System.out.println(freqOfChars);
		
		System.out.println(freqOfChars.values());
		Map<Integer, Character> freqOfChars1 = new TreeMap<>();
		
		for(char key:freqOfChars.keySet()) {
			
			freqOfChars1.put(freqOfChars.get(key), key);
		}
		System.out.println(freqOfChars1);
		
		
		
	}
}
