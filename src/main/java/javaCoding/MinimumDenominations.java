package javaCoding;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class MinimumDenominations {
	
	@Test
	public void minimumDenominations() {
		int amount = 596;
		int[] arr = {1000,500,100,50,20,10,5,2,1};
		Map<Integer, Integer> denominations = new LinkedHashMap<Integer, Integer>();
		int arrIndex=0;
		while(amount>=1) {
			if((amount/arr[arrIndex])>=1) {
				denominations.put(arr[arrIndex], amount/arr[arrIndex]);
			}
			amount = amount%arr[arrIndex];
			arrIndex++;
		}
		System.out.println(denominations);
	}
	
	@Test
	public void minimumDenominationsUsingForLoop() {
	    int amount = 596;
	    int[] denominationsArr = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
	    Map<Integer, Integer> denominations = new LinkedHashMap<>();

	    for (int note : denominationsArr) {
	        if (amount >= note) {
	            int count = amount / note;
	            denominations.put(note, count);
	            amount %= note;
	        }
	    }

	    // Printing output in the required format
	    for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
	        System.out.println(entry.getValue() + " note of " + entry.getKey());
	    }
	}


}
