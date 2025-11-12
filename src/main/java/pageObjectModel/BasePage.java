package pageObjectModel;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public WebDriver driver;
	
	public String userName = "//input[@title='userName']";
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

}
