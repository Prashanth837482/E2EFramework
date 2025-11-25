package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            //https://chatgpt.com/c/6925b0eb-3d7c-8320-bd3f-6bec6545e7d6 -> selenium arguments
            //Below step automatically maximize the window
            options.addArguments("--start-maximized");
            //Opens browser in incognito mode.
            options.addArguments("--incognito");
            driver.set(new ChromeDriver(options));
            //driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
        	//https://chatgpt.com/c/6921d286-5838-8321-aba0-ee8d291a8069 -> reason for using get before closing browser
            driver.get().quit();
            driver.remove();
        }
    }
}
