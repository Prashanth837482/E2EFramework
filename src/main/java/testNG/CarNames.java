package testNG;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CarNames {
	public WebDriver driver;
	@Test
	public void printNames() throws InterruptedException {
		
		String url ="https://www.carandbike.com/new-cars/models/2";
		System.setProperty("webdriver.chrome.driver", "C:\\AutomationJava\\Software\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get(url);
		
		Thread.sleep(3000);
		
		List<WebElement> cars =	driver.findElements(By.xpath("//a[contains(@class,'clTitle')]"));
		Map<String, String> carAndLinks = new HashMap<>();
		for(WebElement car : cars) {
			
			String carName = car.getText();
			String carUrl = car.getAttribute("href");
			
			carAndLinks.put(carName, carUrl);
		}
		
		//System.out.println(carAndLinks);
		for(String key : carAndLinks.keySet()) {
			System.out.println("car name is: "+key+ "car url is: "+carAndLinks.get(key));
		}
		
		driver.close();
	}

}
