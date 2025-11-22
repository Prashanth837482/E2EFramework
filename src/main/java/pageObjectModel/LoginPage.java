package pageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userName = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By dashboard = By.xpath("//div[contains(@class,'userarea')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToApplication(String user, String pass) {
        type(userName, user);
        type(password, pass);
        click(loginButton);
        waitForVisible(dashboard);
    }
}
