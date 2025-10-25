package javaCoding;

import org.testng.annotations.Test;

public class ClosestToZero {
	
	//{-5,-3,-2,2,6,8}
	// find a number that is close to zero. 
	//if two values like -2 and +2 are from above input array are close to zero then fetch positive number as output.
	@Test
	public void ClosestToZeroMeth() {
		int[] arr = {-5,6,8,9,5,1};
		
		int num1=arr[0];
		
		for(int num2 : arr) {
			if(Math.abs(num2)<Math.abs(num1) || (Math.abs(num2)==Math.abs(num1)) && num2>num1) {
				num1 = num2;
			}
		}
		
		System.out.println("closest number to zero in "
				+ ""
				+ "input: "+num1);
	}

}
