package javaCoding;

import java.util.Arrays;

import org.testng.annotations.Test;

public class RotateArrayByKthElement {
	
	// https://chatgpt.com/c/691343b4-cf08-8320-968b-8ac14aea424b   -> rotate array by kth element
	
	@Test
	public void rotateArrayByKthElement() {
		int[] array = {1,2,3,4,5,6,7};
		int KthElement = 3;
		int n = array.length;
		KthElement = KthElement%n;
		
		reverseArray(array, 0, n-1);
		reverseArray(array, 0, KthElement-1);
		reverseArray(array, KthElement, n-1);		
		
		System.out.println(Arrays.toString(array));
	}
	
	public int[] reverseArray(int[] array, int start, int end) {
		while(start<end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
		return array;
	}
	
	@Test
	public void rotateArrayByKthElementLeftShift() {
		int[] array = {1,2,3,4,5,6,7};
		int KthElement = 9;
		int n = array.length;
		KthElement = KthElement%n;   // when k exceeds length in this example we take the remainder as each element has to shift to 9 positions. 
		                              //where there will no change until 7 and changes only after that so will be taking k as 2.
		
		
		  
		reverseArray(array, 0, KthElement-1);
		reverseArray(array, KthElement, n-1); 
		reverseArray(array, 0, n-1); 
		
		System.out.println(Arrays.toString(array));
	}

}
