package ru.training.at.hw4.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.qameta.allure.Step;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw3.data.ExpectedValues;
import ru.training.at.hw4.pages.components.LeftSideSectionMenu;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Check title of Home Page")
    public void checkHomePageTitleEqualsExpected() {
        assertEquals(homePage.getTitle(), ExpectedValues.HOME_PAGE_TITLE);
    }

    @Step("Check title of Different Elements Page")
    public void differentElementsPageHasProperTitle() {
        assertEquals(differentElementsPage.getTitle(), ExpectedValues.DIFFERENT_ELEMENTS_PAGE_TITLE);
    }

    @Step("Check that username is displayed on Home Page and equals {expectedName}")
    public void checkUsernameIsDisplayedAndEqualsExpected(String expectedName) {
        assertTrue(homePage.getUsernameLabel().isDisplayed());
        assertEquals(homePage.getUsernameLabelText(), expectedName);
    }

    @Step("Check that there is proper number of items in Header Section on Home Page")
    public void numberOfItemsInHeaderSectionOnHomePage() {
        assertEquals(homePage.getHeaderSectionMenu().getHeaderSectionMenuItems().size(),
            ExpectedValues.NUMBER_OF_HEADER_SECTION_ELEMENTS);
    }

    @Step("Check that items in Header Section on Home Page have proper names")
    public void itemsOfHeaderSectionOnHomePageHaveProperNames() {
        assertEquals(ExpectedValues.HEADER_SECTION_ELEMENTS_NAMES, homePage.getHeaderSectionMenu()
            .getNamesOfHeaderSectionMenuItems());
    }

    @Step("Check that all items in Header Section on Home Page are displayed")
    public void allItemsInHeaderSectionOnHomePageAreDisplayed() {
        homePage.getHeaderSectionMenu().getHeaderSectionMenuItems()
                     .forEach(element -> assertTrue(element.isDisplayed()));
    }

    @Step("Check that Home Page contains images and they are displayed")
    public void homePageContainsImagesAndTheyAreDisplayed() {
        homePage.getHomePageImages().forEach(image -> assertTrue(image.isDisplayed()));
    }

    @Step("Check that Home Page contains proper number of images")
    public void homePageContainsProperNumberOfImages() {
        assertEquals(homePage.getNumberOfHomePageImages(), ExpectedValues.NUMBER_OF_HOME_PAGE_IMAGES);
    }

    @Step("Check that Home Page contains texts and they are displayed")
    public void homePageContainsTextsAndTheyAreDisplayed() {
        homePage.getHomePageTexts().forEach(text -> assertTrue(text.isDisplayed()));
    }

    @Step("Check that Home Page contains proper number of texts")
    public void homePageContainsProperNumberOfTexts() {
        assertEquals(homePage.getNumberOfHomePageTexts(), ExpectedValues.NUMBER_OF_HOME_PAGE_TEXTS);
    }

    @Step("Check that texts on Home Page have proper values")
    public void textsOnHomePageHaveProperValues() {
        assertEquals(homePage.getHomePageTextsValues(), ExpectedValues.HOME_PAGE_TEXTS);
    }

    @Step("Check that IFrame exists and is displayed on Home Page")
    public void homePageContainsIFrame() {
        assertTrue(homePage.getIframe().isDisplayed());
    }

    @Step("Check that IFrame on Home Page has 'Frame Button'")
    public void iframeOnHomePageContainsFrameButton() {
        assertEquals(homePage.getIframeButtonValue(), ExpectedValues.FRAME_BUTTON_VALUE);
    }

    @Step("Check that all items in left side section on Home Page are displayed")
    public void checkAllItemsInLeftSideSectionOnHomePageAreDisplayed() {
        homePage.getLeftSideSectionMenu().getLeftSectionMenuItems()
            .forEach(element -> assertTrue(element.isDisplayed()));
    }

    @Step("Check that left side section on Home Page contains proper number of items")
    public void leftSideSectionOnHomePageContainsProperNumberOfItems() {
        assertEquals(homePage.getLeftSideSectionMenu().getNumberOfLeftSectionElements(),
            ExpectedValues.NUMBER_OF_LEFT_SECTION_ELEMENTS);
    }

    @Step("Check that items of left side section on Home Page have proper names")
    public void itemsOfLeftSideSectionOnHomePageHaveProperNames() {
        assertEquals(homePage.getLeftSideSectionMenu().getNamesOfLeftSectionElements(),
            ExpectedValues.LEFT_SECTION_ELEMENTS_NAMES);
    }

    @Step("Check that logs on Different Elements Page equal expected")
    public void logsOnDifferentElementsPageEqualExpected(Set<String> expectedLogs) {
        List<String> actualLogs = differentElementsPage.getRightSideSectionMenu().getLogs();
        for (String log : actualLogs) {
            assertTrue(expectedLogs.contains(log.substring(9)), "Log is missing: " + log);
        }
    }
}
