package javaCoding;import java.util.Arrays;

import org.testng.annotations.Test;

import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

public class MoveZeroesOfArrays {
	@Test
	public void moveZeroesOfArrays() {
		int[] originalArray = {5,0,6,6,0,8,7,0,1,0};
		int[] sortedArray = new int[originalArray.length];
		int sortedArrayIndex = 0;
		//System.out.println(sortedArray.toString());
		System.out.println(Arrays.toString(sortedArray));
		for(int index=0; index<originalArray.length; index++) {
			if(originalArray[index]!=0) {
				sortedArray[sortedArrayIndex] = originalArray[index];
				sortedArrayIndex++;
			}
			
		}
		//System.out.println(sortedArray.toString());
		System.out.println(Arrays.toString(sortedArray));
	}
	
	@Test
	public void moveZeroesInPlaceOptimalApproach() {
	    int[] arr = {5,0,6,6,0,8,7,0,1,0};
	    int insertPos = 0;

	    // Move non-zero elements forward (Left side)
	    for (int num : arr) {
	        if (num != 0) {
	            arr[insertPos++] = num;  // appends the index only if non-Zero element is found
	        }
	    }

	    // Fill the rest with zeros
	    while (insertPos < arr.length) {
	        arr[insertPos++] = 0;
	    }

	    System.out.println("In-place result: " + Arrays.toString(arr));
	}


}
