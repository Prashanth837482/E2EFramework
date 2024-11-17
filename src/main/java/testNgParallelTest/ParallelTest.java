package testNgParallelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {
	WebDriver driver;
	
	
	//beofre test will run once before each all the methods in the <test> tag of the xml file .
	// so the cross browser testing can be achieved by passing different browser type in separate test tag.
	@BeforeTest
	@Parameters("browser")
	public void browserSetUp(String browser) {
		
		
		switch (browser) {
		case "chrome":
			
			driver = new ChromeDriver();
			System.out.println("chrome driver is triggered");
			break;
			
		case "edge":
			driver = new EdgeDriver();
			System.out.println("edge driver is triggered");
			break;

		case "fireFox":
			driver = new FirefoxDriver();
			System.out.println("IE driver is triggered");
			break;
		}
	}
	
	@Test
	public void testMethod() throws InterruptedException {
		driver.get("https://www.linkedin.com/feed/");
		Thread.sleep(3000);
		System.out.println("Test method is running in parallel");
		driver.quit();
	}
	
	
	

}
