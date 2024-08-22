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
			driver.manage().window().maximize();
			System.out.println("Window maximized successfully.");
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
		
		// js code to scroll to a particular element
		js.executeScript("arguments[0].scrollIntoView(true);", detectAgainElement);
		System.out.println("Successfully Scrolled to the element");
		Thread.sleep(3000);
		
		// js code to highlight an element
		js.executeScript("arguments[0].style.border='3px solid red'", detectAgainElement);
		System.out.println("Successfully highlighted the element");
		Thread.sleep(3000);
		
		} 
		
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
