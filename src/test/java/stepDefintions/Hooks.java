package stepDefintions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import env.DriverUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    @Before
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        DriverUtil.setDriver(new ChromeDriver());
    }

    @After
    public void teardown() {
        if (DriverUtil.getDriver() != null) {
            DriverUtil.getDriver().quit();
        }
    }

}
