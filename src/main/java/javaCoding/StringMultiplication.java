package javaCoding;

import org.testng.annotations.Test;

public class StringMultiplication {
	
	@Test()
	public void StringMultiplicationMethod() {
		String num1 = "23";
		String num2 = "10";
		
		int intNum1 = Integer.valueOf(num1);
		int intNum2 = Integer.valueOf(num2);
		
		System.out.println(intNum1*intNum2);
	}

}
