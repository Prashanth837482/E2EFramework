package javaCoding;

import java.util.List;

import org.testng.annotations.Test;

public class StarPattern {
	
	@Test
	public void mapListfunc() {
		int size=5;
		
		for(int i =1; i<=5;i++) {
			
			for(int j=1; j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
}
