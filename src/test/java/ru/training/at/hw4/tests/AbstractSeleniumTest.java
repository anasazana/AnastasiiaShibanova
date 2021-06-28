package ru.training.at.hw4.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.training.at.hw4.steps.ActionStep;
import ru.training.at.hw4.steps.AssertionStep;

public abstract class AbstractSeleniumTest {

    protected final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    protected Properties properties;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeSuite
    protected void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    protected void setUp(ITestContext testContext) {
        webDriver.set(new ChromeDriver());
        testContext.setAttribute("driver", webDriver.get());
        webDriver.get().manage().window().maximize();
        webDriver.get().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        actionStep = new ActionStep(webDriver.get());
        assertionStep = new AssertionStep(webDriver.get());
        try {
            properties = new Properties();
            String projectPath = System.getProperty("user.dir");
            properties.load(new FileInputStream(projectPath + "/src/test/resources/config.properties"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(priority = 1, description = "Open Home Page and check that it has proper title")
    protected void homePageHasProperTitle() {
        // 1. Open test site by URL
        actionStep.openHomePage();
        // 2. Assert Browser title
        assertionStep.checkHomePageTitleEqualsExpected();
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
    protected void tearDown() {
        webDriver.get().quit();
    }
}
