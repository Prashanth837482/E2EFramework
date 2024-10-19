package javaCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class interviewInfor {

	
	
		@Test
		public void anagram() {
		
		String[] input = {"eat","tea","tan","ate","nat","bat"};
		
		for(int i =0; i<input.length;i++) {
			
			for(int j =0; j<input.length;j++) {
				int count=0;
				for(char ch:input[i].toCharArray()) { //{e,a,t}
					String char1=""+ch;
					for(char ch2: input[j].toCharArray()) {  //{t,e,a}
						String char2=""+ch2;
						if(char1.contains(char2)) { 
							count++;
						}
					}
				}
				
				if(count==input[i].length() && input[i]!=input[j]) {
					System.out.println("angram of "+input[i]+" is "+input[j]);
				}
			}
		}
		
		
		
		
	}
		
		
		@Test
		public void angramOptimatApproach() {
			//https://chatgpt.com/share/6710fd91-c090-8002-b3a5-23949d69a0ba   --> refer this for code explanation
			String[] strs = {"eat","tea","tan","ate","nat","bat"};
			        // HashMap to store grouped anagrams
			        Map<String, List<String>> map = new HashMap<>();
			        
			        for (String s : strs) {
			            // Sort each string to use it as a key
			            char[] chars = s.toCharArray();
			            Arrays.sort(chars);
			            String sortedKey = new String(chars);
			            
			            // If the sorted version of the string is not in the map, add it
			            if (!map.containsKey(sortedKey)) {
			                map.put(sortedKey, new ArrayList<>());
			            }
			            
			            // Add the original string to the corresponding anagram group
			            map.get(sortedKey).add(s);
			        }
			        
			        // Return the grouped anagrams as a list of lists
			       System.out.println(map.values());
			    
		}
		
		
}
