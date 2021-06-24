package ru.training.at.hw3.tests.ex1;

import org.testng.annotations.Test;
import ru.training.at.hw3.data.ExpectedValues;
import ru.training.at.hw3.pages.components.HeaderSectionMenu;
import ru.training.at.hw3.pages.components.LeftSideSectionMenu;
import ru.training.at.hw3.tests.AbstractSeleniumTest;

public class HomePageTest extends AbstractSeleniumTest {

    // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 3)
    public void headerSectionItemsAreDisplayedAndHaveProperTexts() {
        HeaderSectionMenu headerSection = homePage.getHeaderSectionMenu();
        headerSection.getHeaderSectionMenuItems()
            .forEach(element -> assertCollector.assertTrue(element.isDisplayed(),
                "All header section elements should be displayed."));

        int expectedNumberOfElements = ExpectedValues.NUMBER_OF_HEADER_SECTION_ELEMENTS;
        assertCollector.assertEquals(headerSection.getNumberOfHeaderSectionMenuItems(), expectedNumberOfElements,
            "Actual number of header section elements differs from expected.");

        assertCollector.assertTrue(headerSection.getNamesOfHeaderSectionMenuItems()
            .equals(ExpectedValues.HEADER_SECTION_ELEMENTS_NAMES),
            "Header section elements should have proper names.");
    }

    // 6. Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 4)
    public void homePageContainsProperNumberOfImagesAndTheyAreDisplayed() {
        assertCollector.assertEquals(homePage.getNumberOfHomePageImages(), ExpectedValues.NUMBER_OF_HOME_PAGE_IMAGES,
            "Actual number of images differs from expected.");

        homePage.getHomePageImages()
                .forEach(image -> assertCollector.assertTrue(image.isDisplayed(),
                    "All images should be displayed."));
    }

    // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test(priority = 5)
    public void homePageContainsProperNumberOfTextsDisplayedAndTheyHaveProperValues() {
        homePage.getHomePageTexts()
                .forEach(text -> assertCollector.assertTrue(text.isDisplayed(),
                    "All texts should be displayed."));
        assertCollector.assertEquals(homePage.getNumberOfHomePageTexts(), ExpectedValues.NUMBER_OF_HOME_PAGE_TEXTS,
            "Actual number of texts differs from expected.");
        assertCollector.assertTrue(homePage.getHomePageTextsValues().equals(ExpectedValues.HOME_PAGE_TEXTS),
            "Actual texts differ from expected.");
    }

    // 8. Assert that there is the iframe with “Frame Button” exist
    // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
    @Test(priority = 6)
    public void iframeExistsAndContainsFrameButton() {
        assertCollector.assertTrue(homePage.getIframe().isDisplayed(), "Iframe should be displayed.");
        webDriver.switchTo().frame("frame");
        assertCollector.assertEquals(homePage.getIframeButtonValue(), ExpectedValues.FRAME_BUTTON_VALUE,
            "There should be 'Frame Button' inside the iframe.");
    }

    // 10. Switch to original window back
    // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text

    @Test(priority = 7)
    public void leftSideSectionItemsAreDisplayedAndHaveProperTexts() {
        webDriver.switchTo().defaultContent();
        LeftSideSectionMenu leftSideSection = homePage.getLeftSideSectionMenu();
        leftSideSection.getLeftSectionMenuItems()
            .forEach(element -> assertCollector.assertTrue(element.isDisplayed(),
                "All left side section elements should be displayed."));

        int expectedNumberOfElements = ExpectedValues.NUMBER_OF_LEFT_SECTION_ELEMENTS;
        assertCollector.assertEquals(leftSideSection.getNumberOfLeftSectionElements(), expectedNumberOfElements,
            "Actual number of left side section elements differs from expected.");

        assertCollector.assertTrue(leftSideSection.getNamesOfLeftSectionElements()
             .equals(ExpectedValues.LEFT_SECTION_ELEMENTS_NAMES),
            "Left side section elements should have proper names.");
    }

    // 12. Close Browser
    // Browser is closed from inherited AbstractSeleniumTest.tearDown() method
}
