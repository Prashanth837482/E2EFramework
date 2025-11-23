package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bind.annotation.Super;
import utils.ConfigReader;



public class LoginPageTest extends BaseTest{	
	LoginPage loginPage = null;
	
	@BeforeClass
	public void init() throws InterruptedException {
		
		loginPage = new LoginPage(driver);
		
	}
	
	 

	@Test
	public void testLogin() {		
		boolean loginStatus = loginPage.loginToApplication(ConfigReader.get("username"), ConfigReader.get("password"));
		Assert.assertTrue(loginStatus,"Login failed..");
		Assert.assertTrue(loginPage.validateSearchSvgIcon(), "Failed to validate the Search Svg Icon");
	}
}
