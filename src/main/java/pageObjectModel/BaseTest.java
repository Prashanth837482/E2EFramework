package pageObjectModel;



import utils.DriverManager; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        ConfigReader.loadConfig();
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.get("url"));
        //driver.manage().window().maximize();
        
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
