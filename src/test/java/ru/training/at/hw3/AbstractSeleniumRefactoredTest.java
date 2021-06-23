package ru.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.utils.ExpectedValues;
import ru.training.at.hw3.utils.HomePage;

public abstract class AbstractSeleniumRefactoredTest {

    protected WebDriver webDriver;
    protected SoftAssert assertCollector;
    protected HomePage homePage;
    protected Properties properties;
    private String homePageURL;

    @BeforeClass
    protected void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        assertCollector = new SoftAssert();
        try {
            properties = new Properties();
            String projectPath = System.getProperty("user.dir");
            properties.load(new FileInputStream(projectPath + "/src/test/resources/config.properties"));
            homePageURL = properties.getProperty("homePageUrl");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    protected void homePageHasProperTitle() {
        // 1. Open test site by URL
        webDriver.navigate().to(homePageURL);
        homePage = new HomePage(webDriver);

        // 2. Assert Browser title
        String actualTitle = webDriver.getTitle();
        String expectedTitle = ExpectedValues.HOME_PAGE_TITLE;
        assertCollector.assertEquals(actualTitle, expectedTitle,
            "Page title should be " + expectedTitle);
    }

    @Test(priority = 2)
    protected void afterLoginProperUsernameIsDisplayed() {
        // 3. Perform login
        homePage.openDropdownLoginForm();
        homePage.sendKeysToUsernameTextField(properties.getProperty("username"));
        homePage.sendKeysToPasswordTextField(properties.getProperty("password"));
        homePage.clickLoginButton();

        // 4. Assert Username is loggined
        assertCollector.assertTrue(homePage.getUsernameLabel().isDisplayed());
        String expectedName = properties.getProperty("user");
        assertCollector.assertEquals(homePage.getUsernameLabelText(), expectedName,
            "Displayed username should be " + expectedName + ".");
    }

    @AfterClass
    protected void tearDown() {
        assertCollector.assertAll();
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
