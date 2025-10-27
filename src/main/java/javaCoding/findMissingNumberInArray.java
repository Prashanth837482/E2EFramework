package javaCoding;

import java.util.Arrays;

import org.testng.annotations.Test;

public class findMissingNumberInArray {
	
	@Test
	public void findMissingNumberInArray() {
		int[] numbers = {28,26,29,25};
		int numberOfelements = 5;
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		int firstNum = numbers[0];
		for(int i=0; i<numberOfelements; i++) {
			if(numbers[i]==firstNum) {
				firstNum++;
			}
			else {
				System.out.println("Missing number is: "+firstNum);
				break;
			}
		}
		
	}

}
