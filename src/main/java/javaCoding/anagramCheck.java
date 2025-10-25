package javaCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class anagramCheck {
	@Test
	public void anagramcheck() {
		String[] input = {"eat","tea","tan","ate","nat","bat"};
		Map<String,List<String>> map = new HashMap<>();
		for(String element : input) {
			char[] arr = element.toCharArray();
			Arrays.sort(arr);
			String s = new String(arr);
			
			if(!map.containsKey(s)) {
				map.put(s, new ArrayList<>());
			}
			map.get(s).add(element);
			
		}
		
		System.out.println(map.values());
		
	}

}
