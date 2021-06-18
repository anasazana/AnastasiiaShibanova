package ru.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public abstract class AbstractSeleniumTest {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected SoftAssert softAssert;

    @BeforeClass
    protected void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 1);
        softAssert = new SoftAssert();
    }

    @Test(priority = 1)
    protected void openHomePageAndLogInTest() {
        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        String actualTitle = webDriver.getTitle();
        softAssert.assertEquals(actualTitle, "Home Page", "Page title should be 'Home Page'");

        // 3. Perform login
        webDriver.findElement(By.xpath("//li[@class='dropdown uui-profile-menu']/a[@class='dropdown-toggle']"))
                 .click();
        webDriver.findElement(By.cssSelector("input[id=name]")).sendKeys("Roman");
        webDriver.findElement(By.cssSelector("input[id=password]")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        softAssert.assertEquals(element.getText(), "ROMAN IOVLEV",
            "Displayed username should be " + "ROMAN IOVLEV" + ".");
    }

    @AfterClass
    protected void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
