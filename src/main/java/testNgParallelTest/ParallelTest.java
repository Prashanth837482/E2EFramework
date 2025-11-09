package testNgParallelTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		
		System.out.println(driver.manage().window().getSize());
		
		//driver.manage().window().getSize();
		
		driver.manage().window().maximize();
		
		System.out.println(driver.manage().window().getSize());
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//To delete cookies
		driver.manage().deleteAllCookies();
		//To set the size of the window
		Dimension d = new Dimension(500, 500);
		driver.manage().window().setSize(d);
		Thread.sleep(2000);
		//To set the position of the window
		Point p = new Point(250, 250);
		driver.manage().window().setPosition(p);
		Thread.sleep(2000);

		
		
		// To open a new window 
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		//Launch url in newly opened window
		driver.get("https://mail.google.com");
		
		// To open a new Tab 
		driver.switchTo().newWindow(WindowType.TAB);
		
		//Launch url in newly opened Tab
		driver.get("https://mail.google.com");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement test =driver.findElement(By.xpath("test"));
		wait.until(ExpectedConditions.visibilityOf(test));
		
		FluentWait fw = new FluentWait(driver);
		fw.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMinutes(30)).ignoring(NoSuchElementException.class);
		fw.until(ExpectedConditions.elementToBeClickable(test));
		
		driver.switchTo().parentFrame();
		
		Actions act = new Actions(driver);
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("test.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		driver.quit();
	}
	
	
	

}
