package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

public class StepDefinitions {
	
	static public WebDriver driver;
	

	@Given("I Launch {string} application")
	public void i_launch_application(String application) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\AutomationJava\\Software\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver= new ChromeDriver();
			
			if(application.contains("Amazon")) {
				driver.get("https://www.amazon.in/");			
				Thread.sleep(3000);
				System.out.println("Successfully Launched "+ application + " application");
			}
		
		}
		catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
