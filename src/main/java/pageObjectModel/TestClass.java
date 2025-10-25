package pageObjectModel;

import org.testng.annotations.Test;

import net.bytebuddy.implementation.bind.annotation.Super;



public class TestClass{
	PageClass pageClass = new PageClass();

	@Test
	public void testLogin() {
		
		System.out.println(pageClass.userName);
		System.out.println(pageClass.passWord);
	}
}
