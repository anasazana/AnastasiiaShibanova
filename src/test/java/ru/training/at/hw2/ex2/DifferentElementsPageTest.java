package ru.training.at.hw2.ex2;

import java.util.List;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.AbstractSeleniumTest;

public class DifferentElementsPageTest extends AbstractSeleniumTest {

    @Test(dataProvider = "loginDataProvider")
    public void loggedInDifferentElementsPageTest(String login, String password, String displayedUsername) {

        SoftAssert softAssert = new SoftAssert();
        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page", "Page title should be 'Home Page'");

        // 3. Perform login
        webDriver.findElement(By.xpath("//li[@class='dropdown uui-profile-menu']/a[@class='dropdown-toggle']"))
                 .click();
        webDriver.findElement(By.cssSelector("input[id=name]")).sendKeys(login);
        webDriver.findElement(By.cssSelector("input[id=password]")).sendKeys(password);
        webDriver.findElement(By.id("login-button")).click();

        // 4. Assert User name in the right-top side of screen that user is loggined
        WebElement usernameLabel = new WebDriverWait(webDriver, 1)
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        softAssert.assertEquals(usernameLabel.getText(), displayedUsername,
            "Displayed username should be " + displayedUsername + ".");

        // 5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']"))
                 .click();
        WebElement differentElementsPageButton = new WebDriverWait(webDriver, 3)
            .until(ExpectedConditions
                .visibilityOfElementLocated(By
                    .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='different-elements.html']")));
        differentElementsPageButton.click();
        softAssert.assertEquals(webDriver.getTitle(), "Different Elements",
            "Page Title should be 'Different Elements'");

        // 6. Select checkboxes
        List<WebElement> checkBoxes = new WebDriverWait(webDriver, 3)
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("label[class=label-checkbox]")));

        for (WebElement checkBox : checkBoxes) {
            String checkBoxLabel = checkBox.getText();
            if (checkBoxLabel.contains("Water") || checkBoxLabel.contains("Wind")) {
                checkBox.click();
                softAssert.assertTrue(checkBox.findElement(By.cssSelector("input[type=checkbox]"))
                                              .isSelected(),
                    checkBoxLabel + " checkbox is not selected:");
            }
        }

        // 7. Select radio
        List<WebElement> radioButtons = new WebDriverWait(webDriver, 3)
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("label[class=label-radio]")));

        Optional<WebElement> selenRadioButtonOptional = radioButtons.stream()
                                                                    .filter(
                                                                        button -> button.getText().contains("Selen"))
                                                                    .findFirst();
        if (selenRadioButtonOptional.isPresent()) {
            WebElement selenRadioButton = selenRadioButtonOptional.get();
            selenRadioButton.click();
            softAssert.assertTrue(selenRadioButton.findElement(By.cssSelector("input[type=radio]"))
                                                  .isSelected(), "Selen radio button is not selected:");
        } else {
            softAssert.fail("Selen radio button does not exist");
        }

        // 8. Select in dropdown
        WebElement selectColorDropdown = webDriver.findElement(By.cssSelector("select[class=uui-form-element]"));
        selectColorDropdown.click();
        List<WebElement> colorOptions = new WebDriverWait(webDriver, 3)
            .until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.cssSelector("select[class=uui-form-element] option")));

        Optional<WebElement> colorElementOptional = colorOptions.stream()
                                                                .filter(button -> button.getText().contains("Yellow"))
                                                                .findFirst();
        if (colorElementOptional.isPresent()) {
            WebElement colorElement = colorElementOptional.get();
            colorElement.click();
            softAssert.assertTrue(colorElement.isSelected(), "Yellow color option is not selected:");
        } else {
            softAssert.fail("Yellow color option does not exist.");
        }

        // 9. Assert that
        // - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // - for radio button there is a log row and value is corresponded to the status of radio button
        // - for dropdown there is a log row and value is corresponded to the selected value.
        String[] expectedLogs = new String[] {
            "Colors: value changed to Yellow",
            "metal: value changed to Selen",
            "Wind: condition changed to true",
            "Water: condition changed to true"
        };
        List<WebElement> actualLogs = new WebDriverWait(webDriver, 3)
            .until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='panel-body-list logs']/li")));

        for (int i = 0; i < actualLogs.size(); i++) {
            softAssert.assertTrue(actualLogs.get(i).getText().contains(expectedLogs[i]),
                "Log is missing: " + expectedLogs[i]);
        }

        softAssert.assertAll();

        // 10. Close Browser
        // Browser is closed from inherited AbstractSeleniumTest.tearDown() method
    }

    @DataProvider
    private Object[][] loginDataProvider() {
        return new Object[][] {
            {"Roman", "Jdi1234", "ROMAN IOVLEV"}
        };
    }
}
