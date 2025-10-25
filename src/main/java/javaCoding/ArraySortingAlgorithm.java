package javaCoding;

import java.util.Arrays;

import org.testng.annotations.Test;

public class ArraySortingAlgorithm {
	
		
	//https://chatgpt.com/c/68ce4c79-384c-832c-a558-16b857c2fc53     - for content about algorithms
	
	
	@Test
	public void bubbleSortAlgorithm() {
		int[] unsortedArray = {5, 1, 4, 2, 8};
		int arrLength = unsortedArray.length;
		for(int i =0; i<arrLength-1; i++) {    
			for(int j=0; j<arrLength-1-i; j++) {
				if(unsortedArray[j]>unsortedArray[j+1]) {
					int temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j+1];
					unsortedArray[j+1] = temp;
					
				}
			}
		}
		
		System.out.println(Arrays.toString(unsortedArray));
	}
	
	//Below question asked in ServiceNow L-2: https://chatgpt.com/c/68d2639d-034c-8328-90f6-65df04facd5d
	@Test
	public void findThirdLargestNumWithoutUsingSortingAndDefaultMethods() {
		int[] unsortedArray = {10,6,8,-2,6,65,-65,55,55};
		int firstLargestNum = Integer.MIN_VALUE;
		int secondLargestNum = Integer.MIN_VALUE;
		int thirdLargestNum = Integer.MIN_VALUE;
		for(int currentNum : unsortedArray) {
			
			if(currentNum > firstLargestNum) {
				thirdLargestNum = secondLargestNum;
				secondLargestNum = firstLargestNum;
				firstLargestNum = currentNum;
			}
			else if(currentNum > secondLargestNum && currentNum != firstLargestNum) {
				thirdLargestNum = secondLargestNum;
				secondLargestNum = currentNum;
			}
			else if(currentNum > thirdLargestNum && currentNum != secondLargestNum) {				
				thirdLargestNum = currentNum;
				
			}
		}
		
		System.out.println("First Largest number in array is : "+firstLargestNum);
		System.out.println("Second Largest number in array is : "+secondLargestNum);
		System.out.println("Third Largest number in array is : "+thirdLargestNum);
	}

}
