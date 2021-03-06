package ru.training.at.hw4.tests.passing.ex1;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import ru.training.at.hw4.data.ExpectedValues;
import ru.training.at.hw4.tests.AbstractSeleniumTest;

@Feature("Home Page contents check")
public class HomePageTest extends AbstractSeleniumTest {

    // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 3,
          description = "Check that there are 4 items on the header section are displayed and they have proper texts")
    public void headerSectionItemsAreDisplayedAndHaveProperTexts() {
        assertionStep.numberOfItemsInHeaderSectionOnHomePage(ExpectedValues.NUMBER_OF_HEADER_SECTION_ELEMENTS);
        assertionStep.allItemsInHeaderSectionOnHomePageAreDisplayed();
        assertionStep.itemsOfHeaderSectionOnHomePageHaveProperNames(ExpectedValues.HEADER_SECTION_ELEMENTS_NAMES);
    }

    // 6. Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 4, description = "Check that there are 4 images on the Index Page and they are displayed")
    public void homePageContainsProperNumberOfImagesAndTheyAreDisplayed() {
        assertionStep.homePageContainsImagesAndTheyAreDisplayed();
        assertionStep.homePageContainsProperNumberOfImages(ExpectedValues.NUMBER_OF_HOME_PAGE_IMAGES);
    }

    // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 5,
          description = "Check that there are 4 texts on the Index Page under icons and they have proper text")
    public void homePageContainsProperNumberOfTextsDisplayedAndTheyHaveProperValues() {
        assertionStep.homePageContainsTextsAndTheyAreDisplayed();
        assertionStep.homePageContainsProperNumberOfTexts(ExpectedValues.NUMBER_OF_HOME_PAGE_TEXTS);
        assertionStep.textsOnHomePageHaveProperValues(ExpectedValues.HOME_PAGE_TEXTS);
    }

    // 8. Assert that there is the iframe with “Frame Button” exist
    // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
    @Test(priority = 6, description = "Check that Home Page contains IFrame with 'Frame Button' in it")
    public void iframeExistsAndContainsFrameButton() {
        assertionStep.homePageContainsIFrame();
        actionStep.switchToIframeOnHomePage();
        assertionStep.iframeOnHomePageContainsFrameButtonWithProperValue(ExpectedValues.FRAME_BUTTON_VALUE);
    }

    // 10. Switch to original window back
    // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test(priority = 7,
          description = "Check that there are 5 items in the Left Section are displayed and they have proper texts")
    public void leftSideSectionItemsAreDisplayedAndHaveProperTexts() {
        actionStep.switchToHomePage();
        assertionStep.checkAllItemsInLeftSideSectionOnHomePageAreDisplayed();
        assertionStep
            .leftSideSectionOnHomePageContainsProperNumberOfItems(ExpectedValues.NUMBER_OF_LEFT_SECTION_ELEMENTS);
        assertionStep.itemsOfLeftSideSectionOnHomePageHaveProperNames(ExpectedValues.LEFT_SECTION_ELEMENTS_NAMES);
    }

    // 12. Close Browser
    // Browser is closed from inherited AbstractSeleniumTest.tearDown() method
}
