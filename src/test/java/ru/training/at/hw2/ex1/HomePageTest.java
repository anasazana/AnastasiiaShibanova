package ru.training.at.hw2.ex1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.AbstractSeleniumTest;

public class HomePageTest extends AbstractSeleniumTest {

    @Test (dataProvider = "loginDataProvider")
    public void loggedInHomePageTest(String login, String password, String displayedUsername) {

        SoftAssert softAssert = new SoftAssert();
        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        String actualTitle = webDriver.getTitle();
        softAssert.assertEquals(actualTitle, "Home Page", "Page title should be 'Home Page'");

        // 3. Perform login
        webDriver.findElement(By.xpath("//li[@class='dropdown uui-profile-menu']/a[@class='dropdown-toggle']"))
                 .click();
        webDriver.findElement(By.cssSelector("input[id=name]")).sendKeys(login);
        webDriver.findElement(By.cssSelector("input[id=password]")).sendKeys(password);
        webDriver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined
        WebElement element = new WebDriverWait(webDriver, 1)
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        softAssert.assertEquals(element.getText(), displayedUsername,
            "Displayed username should be " + displayedUsername + ".");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerSectionElements = new WebDriverWait(webDriver, 1)
            .until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a")));
        softAssert.assertEquals(headerSectionElements.size(), 4,
            "There should be 4 elements in header section.");
        String[] headerSectionElementsNames = new String[] {
            "HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS"
        };
        for (int i = 0; i < 4; i++) {
            softAssert.assertEquals(headerSectionElements.get(i).getText(), headerSectionElementsNames[i],
                "Wrong name of header section element.");
        }

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> indexPageImages = new WebDriverWait(webDriver, 1)
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class=benefit-icon]")));
        softAssert.assertEquals(indexPageImages.size(), 4,
            "There should be 4 images displayed.");

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> indexPageTexts = new WebDriverWait(webDriver, 1)
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span[class=benefit-txt]")));
        softAssert.assertEquals(indexPageTexts.size(), 4,
            "There should be 4 texts displayed.");
        String[] texts = new String[] {
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
        };
        for (int i = 0; i < 4; i++) {
            softAssert.assertEquals(indexPageTexts.get(i).getText(), texts[i],
                "Actual text differs from expected.");
        }

        // 8. Assert that there is the iframe with “Frame Button” exist
        List<WebElement> iframe = webDriver.findElements(By.id("frame"));
        softAssert.assertTrue(iframe.size() > 0, "Iframe does not exist.");

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        softAssert.assertEquals(webDriver.findElement(By.id("frame-button"))
                                         .getAttribute("value"), "Frame Button",
            "There should be 'Frame Button' inside the iframe.");

        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSectionElements = new WebDriverWait(webDriver, 1)
            .until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='sidebar-menu left']/li/a/span")));
        softAssert.assertEquals(leftSectionElements.size(), 5,
            "There should be 5 items in the Left Section.");
        String[] leftSectionElementsNames = new String[] {
            "Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs"
        };
        for (int i = 0; i < 5; i++) {
            softAssert.assertEquals(leftSectionElements.get(i).getText(), leftSectionElementsNames[i],
                "Actual Left Section item's name differs from expected.");
        }

        softAssert.assertAll();

        // 12. Close Browser
        // Browser is closed from inherited AbstractSeleniumTest.tearDown() method
    }

    @DataProvider
    private Object[][] loginDataProvider() {
        return new Object[][]{
            {"Roman", "Jdi1234", "ROMAN IOVLEV"}
        };
    }
}
