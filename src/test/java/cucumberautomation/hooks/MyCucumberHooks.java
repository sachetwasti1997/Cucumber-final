package cucumberautomation.hooks;

import cucumberautomation.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class MyCucumberHooks {

    private WebDriver webDriver;

    @Before
    public void before(){
        webDriver = DriverFactory.initialiseDriver();
    }

    @After
    public void after(){
        webDriver.quit();
    }

}
