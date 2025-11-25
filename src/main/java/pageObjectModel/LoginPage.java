package pageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userName = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By dashboard = By.xpath("//div[contains(@class,'userarea')]");
    private By searchSvgIcon = By.xpath("//div[contains(@class,'search')]/*[name()='svg']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean loginToApplication(String user, String pass) {
    	
    	try {
	        type(userName, user);
	        type(password, pass);
	        click(loginButton);
	        waitForVisible(dashboard);
	        return true;
    	}
    	// https://chatgpt.com/c/6925de02-b628-8322-bbe9-2692a5da4f3b
    	// TimeOutException or any exception occured in type, click methods will not throw error as we are catching exception below
    	// we have to remove below catch to block to capture the exceptions.
    	catch(Exception e){
    		return false;
    	}
    }
    
    public boolean validateSearchSvgIcon() {
    	return validateSvgIcon(searchSvgIcon);
    }
}
