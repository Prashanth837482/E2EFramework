package javaCoding;

import org.testng.annotations.Test;

public class ExcelSheetColumnNumber {

	
	@Test
	public void ExcelSheetColumnNumberMethod() {
		
		String columnName = "ZZZ";
		int multiplier = 0;
		int finalValue = 0;
		
		// iterating over each character form the column name
		for(int i = columnName.length()-1; i>=0; i--) {
			
			// get the alphaber value by using asci value and subtract by 64 as "A" is 65
			int asciVal = columnName.charAt(i)-64;
			System.out.println("accivalue of : "+columnName.charAt(i)+ "is: "+asciVal);
			
			//approach on below mathematical equaltion
			// https://chatgpt.com/c/66eef4bc-aa44-8002-83be-49672e82b366
			int currentSum = (int) (asciVal * Math.pow(26, multiplier));
			finalValue += currentSum;
			System.out.println("sum after character: "+currentSum);
			
			
			multiplier++;
		}
		System.out.println(finalValue);
	}
}
