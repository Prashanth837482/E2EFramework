package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

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
	
	
	@When("I create and pass DataTable data")
	public void i_create_and_pass_data_table_data(io.cucumber.datatable.DataTable dataTable) {
		
		try {
			
			List<Map<String,String>> maps = dataTable.asMaps(String.class, String.class);
			
			for(Map<String,String> map: maps) {
				System.out.println(map); // printing each map
				for(String value:map.values()) {
					System.out.println(value); // printing values of each map
				}
			}
			
		}
		
		catch(Exception e) {
			throw e;
		}
		
	}


}
