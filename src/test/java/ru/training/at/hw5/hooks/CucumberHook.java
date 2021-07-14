package ru.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.drivers.WebDriverFactory;

public class CucumberHook {

    @Before
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        TestContext.getInstance().addTestObject("driver", WebDriverFactory.createWebDriver("chrome"));
    }

    @After
    public void closeDriver() {
        ((WebDriver) TestContext.getInstance().getTestObject("driver")).quit();
        TestContext.getInstance().clean();
    }
}
