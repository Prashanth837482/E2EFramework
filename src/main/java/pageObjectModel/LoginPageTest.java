package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bind.annotation.Super;
import utils.ConfigReader;



public class LoginPageTest extends BaseTest{
	//WebDriver driver;
	LoginPage loginPage = null;
	
	@BeforeClass
	public void init() throws InterruptedException {
		
		//driver = initializeDriver();
		loginPage = new LoginPage(driver);
		
	}
	
	 

	@Test
	public void testLogin() {		
		loginPage.loginToApplication(ConfigReader.get("username"), ConfigReader.get("password"));
		
	}
}
