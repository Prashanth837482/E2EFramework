package javaCoding;

import java.util.*;
import org.testng.annotations.Test;

public class sumOfTwoIndicesInArray {
	
	//https://chatgpt.com/c/69059ad5-7548-8320-905d-c14368aed1b6   -> explanation and code.
	
	// Function to fetch the two values that sums up to provide target number in an array
	@Test
	public void sumOfTwoNumbersInArrayToGetTarget() {
		int[] array = {2,3,7,11,6,5,15,4};
		int target = 9;
		List<List<Integer>> resultList  = new ArrayList<>();
		Map<Integer, Integer> numAndIndexMap = new HashMap<>(); // stores number -> index
		for(int i=0; i<array.length; i++) {
			int complement = target - array[i];
			
			if(numAndIndexMap.containsKey(complement)) {
				resultList.add(Arrays.asList(complement,array[i]));
			}
			// Always put the current number after checking, so pairs are unique
			numAndIndexMap.put(array[i], i);
		}
		
		
		System.out.println("sumOfTwoNumbersInArrayToGetTarget: "+resultList);
	}
	
	@Test
	public void sumOfTwoIndicesInArrayToGetTarget() {
		int[] array = {2,3,7,11,6,5,15,4};
		int target = 9;
		List<List<Integer>> resultList  = new ArrayList<>();
		Map<Integer, Integer> numAndIndexMap = new HashMap<>(); // stores number -> index
		for(int i=0; i<array.length; i++) {
			int complement = target - array[i];
			
			if(numAndIndexMap.containsKey(complement)) {
				// As we need indexes of elements, we get the index for the respective number from map for complement num
				resultList.add(Arrays.asList(numAndIndexMap.get(complement),i));
			}
			// Always put the current number after checking, so pairs are unique
			numAndIndexMap.put(array[i], i);
		}
		
		
		System.out.println("sumOfTwoIndicesInArrayToGetTarget: "+resultList);
	}


}
