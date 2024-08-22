package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutorCommands {

	public static WebDriver driver;
	
	
	@BeforeTest
	public void setUpMethod() throws Exception {
		
		try {	
			System.setProperty("webdriver.chrome.driver", "C:\\AutomationJava\\Software\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("https://in.search.yahoo.com/search?fr=mcafee&type=E210IN826G0&p=google");		
			Thread.sleep(5000);
			
		}
		
		catch(Exception e) {
			throw e;
		}
		
	}
	
	@AfterMethod
	public void tearDownMethod() {
		driver.close();
	}
	
	@Test
	public void ScrollToElement() {
		
		
		try {
		
		WebElement detectAgainElement= driver.findElement(By.xpath("//a[text()='Detect again']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", detectAgainElement);
		Thread.sleep(5000);
		
		} 
		
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
