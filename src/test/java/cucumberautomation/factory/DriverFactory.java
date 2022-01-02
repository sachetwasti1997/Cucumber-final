package cucumberautomation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver webDriver;

    public static WebDriver initialiseDriver(){
        System.setProperty("webdriver.chrome.driver","/home/sachet/Documents/chromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

}
