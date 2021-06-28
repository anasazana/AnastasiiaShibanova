package ru.training.at.hw4.tests.passing.ex1;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import ru.training.at.hw4.tests.AbstractSeleniumTest;

@Feature("Home Page contents check")
public class HomePageTest extends AbstractSeleniumTest {

    // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 3)
    public void headerSectionItemsAreDisplayedAndHaveProperTexts() {
        assertionStep.numberOfItemsInHeaderSectionOnHomePage();
        assertionStep.allItemsInHeaderSectionOnHomePageAreDisplayed();
        assertionStep.itemsOfHeaderSectionOnHomePageHaveProperNames();
    }

    // 6. Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 4)
    public void homePageContainsProperNumberOfImagesAndTheyAreDisplayed() {
        assertionStep.homePageContainsImagesAndTheyAreDisplayed();
        assertionStep.homePageContainsProperNumberOfImages();
    }

    // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 5)
    public void homePageContainsProperNumberOfTextsDisplayedAndTheyHaveProperValues() {
        assertionStep.homePageContainsTextsAndTheyAreDisplayed();
        assertionStep.homePageContainsProperNumberOfTexts();
        assertionStep.textsOnHomePageHaveProperValues();
    }

    // 8. Assert that there is the iframe with “Frame Button” exist
    // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
    @Test(priority = 6)
    public void iframeExistsAndContainsFrameButton() {
        assertionStep.homePageContainsIFrame();
        actionStep.switchToIframeOnHomePage();
        assertionStep.iframeOnHomePageContainsFrameButton();
    }

    // 10. Switch to original window back
    // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text

    @Test(priority = 7)
    public void leftSideSectionItemsAreDisplayedAndHaveProperTexts() {
        actionStep.switchToHomePage();
        assertionStep.checkAllItemsInLeftSideSectionOnHomePageAreDisplayed();
        assertionStep.leftSideSectionOnHomePageContainsProperNumberOfItems();
        assertionStep.itemsOfLeftSideSectionOnHomePageHaveProperNames();
    }

    // 12. Close Browser
    // Browser is closed from inherited AbstractSeleniumTest.tearDown() method
}
