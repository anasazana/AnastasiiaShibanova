package ru.training.at.hw6.steps;

import static org.testng.Assert.assertTrue;
import static org.testng.FileAssert.fail;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.training.at.hw6.data.ExpectedValues;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Open Home Page")
    public void openHomePage() {
        homePage.open();
    }

    @Step("Click on Service -> {menuItem} in Home Page Header Section")
    public void clickOnHeaderSectionServiceMenuItem(String menuItem) {
        homePage.getHeaderSectionMenu().clickOnHeaderSectionMenuItem(ExpectedValues.HEADER_MENU_SERVICE_BUTTON_VALUE);
        homePage.getHeaderSectionMenu().clickOnServiceDropdownMenuItem(menuItem);
    }

    @Step("Login with existing User data: user {username} password {password}")
    public void loginWithExistingUserData(String username, String password) {
        homePage.openDropdownLoginForm();
        homePage.sendKeysToUsernameTextField(username);
        homePage.sendKeysToPasswordTextField(password);
        homePage.clickLoginButton();
    }

    @Step("Switch to IFrame on Home Page")
    public void switchToIframeOnHomePage() {
        driver.switchTo().frame("frame");
    }

    @Step("Switch to Home Page")
    public void switchToHomePage() {
        driver.switchTo().defaultContent();
    }

    @Step("Select {elementsToSelect} check boxes on Different Elements Page")
    public void selectCheckBoxesOnDifferentElementsPage(String[] elementsToSelect) {
        for (String elementName : elementsToSelect) {
            WebElement elementSelected = differentElementsPage.selectElement(elementName);
            if (elementSelected != null) {
                assertTrue(elementSelected.isDisplayed());
                assertTrue(differentElementsPage.getElementCheckBox(elementSelected).isSelected());
            } else {
                fail(elementName + " checkbox does not exist.");
            }
        }
    }

    @Step("Select {metalToSelect} radio button on Different Elements Page")
    public void selectMetalRadioButtonOnDifferentElementsPage(String metalToSelect) {
        WebElement metalSelected = differentElementsPage.selectMetal(metalToSelect);
        if (metalSelected != null) {
            assertTrue(metalSelected.isDisplayed());
            assertTrue(differentElementsPage.getMetalRadioButton(metalSelected).isSelected());
        } else {
            fail(metalToSelect + " radio button does not exist.");
        }
    }

    @Step("Open color dropdown menu on Different Elements Page")
    public void openColorDropdownMenuOnDifferentElementsPage() {
        differentElementsPage.openColorDropdownMenu();
    }

    @Step("Select {colorToSelect} color on Different Elements Page")
    public void selectColorOnDifferentElementsPage(String colorToSelect) {
        WebElement colorSelected = differentElementsPage.selectColor(colorToSelect);
        if (colorSelected != null) {
            assertTrue(colorSelected.isDisplayed());
            assertTrue(colorSelected.isSelected());
        } else {
            fail(colorToSelect + " color option does not exist.");
        }
    }
}
