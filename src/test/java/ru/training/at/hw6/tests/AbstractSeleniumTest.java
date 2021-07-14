package ru.training.at.hw6.tests;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.training.at.hw6.data.ExpectedValues;
import ru.training.at.hw6.drivers.WebDriverFactory;
import ru.training.at.hw6.steps.ActionStep;
import ru.training.at.hw6.steps.AssertionStep;

public abstract class AbstractSeleniumTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected Properties properties;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeClass
    @Parameters(value = {"browser", "type"})
    protected void setUp(String browser, String type, ITestContext testContext) {
        driver.set(WebDriverFactory.createWebDriver(type, browser));
        testContext.setAttribute("driver", driver);
        driver.get().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        actionStep = new ActionStep(driver.get());
        assertionStep = new AssertionStep(driver.get());
        try {
            properties = new Properties();
            String projectPath = System.getProperty("user.dir");
            properties.load(new FileInputStream(projectPath + "/src/test/resources/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1, description = "Open Home Page and check that it has proper title")
    protected void homePageHasProperTitle() {
        // 1. Open test site by URL
        actionStep.openHomePage();
        // 2. Assert Browser title
        assertionStep.checkHomePageTitleEqualsExpected(ExpectedValues.HOME_PAGE_TITLE);
    }

    @Test(priority = 2,
          description = "Log in with valid user data and check that username label on Home Page contains proper name")
    protected void afterLoginProperUsernameIsDisplayed() {
        // 3. Perform login
        actionStep.loginWithExistingUserData(properties.getProperty("username"), properties.getProperty("password"));
        // 4. Assert Username is loggined
        assertionStep.checkUsernameIsDisplayedAndEqualsExpected(properties.getProperty("user"));
    }

    @AfterClass
    protected void tearDown(ITestContext testContext) {
        if (!Objects.isNull(driver.get())) {
            driver.get().quit();
            driver.remove();
        }
    }
}
