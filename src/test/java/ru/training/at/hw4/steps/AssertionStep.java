package ru.training.at.hw4.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.qameta.allure.Step;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("The title of Home Page is {title}")
    public void checkHomePageTitleEqualsExpected(String title) {
        assertEquals(homePage.getTitle(), title);
    }

    @Step("The title of Different Elements Page is {title}")
    public void differentElementsPageHasProperTitle(String title) {
        assertEquals(differentElementsPage.getTitle(), title);
    }

    @Step("Username displayed on Home Page is {expectedName}")
    public void checkUsernameIsDisplayedAndEqualsExpected(String expectedName) {
        assertTrue(homePage.getUsernameLabel().isDisplayed());
        assertEquals(homePage.getUsernameLabelText(), expectedName);
    }

    @Step("There are {numberOfItems} items in Header Section menu on Home Page")
    public void numberOfItemsInHeaderSectionOnHomePage(int numberOfItems) {
        assertEquals(homePage.getHeaderSectionMenu().getHeaderSectionMenuItems().size(), numberOfItems);
    }

    @Step("Items of Header Section menu on Home Page have names: {names}")
    public void itemsOfHeaderSectionOnHomePageHaveProperNames(List<String> names) {
        assertEquals(names, homePage.getHeaderSectionMenu().getNamesOfHeaderSectionMenuItems());
    }

    @Step("All items of Header Section menu on Home Page are displayed")
    public void allItemsInHeaderSectionOnHomePageAreDisplayed() {
        homePage.getHeaderSectionMenu().getHeaderSectionMenuItems()
                     .forEach(element -> assertTrue(element.isDisplayed()));
    }

    @Step("Home Page contains images and they are displayed")
    public void homePageContainsImagesAndTheyAreDisplayed() {
        homePage.getHomePageImages().forEach(image -> assertTrue(image.isDisplayed()));
    }

    @Step("Home Page contains {numberOfImages} images")
    public void homePageContainsProperNumberOfImages(int numberOfImages) {
        assertEquals(homePage.getNumberOfHomePageImages(), numberOfImages);
    }

    @Step("Home Page contains texts and they are displayed")
    public void homePageContainsTextsAndTheyAreDisplayed() {
        homePage.getHomePageTexts().forEach(text -> assertTrue(text.isDisplayed()));
    }

    @Step("Home Page contains {numberOfTexts} of texts")
    public void homePageContainsProperNumberOfTexts(int numberOfTexts) {
        assertEquals(homePage.getNumberOfHomePageTexts(), numberOfTexts);
    }

    @Step("Texts on Home Page are: {homePageTexts}")
    public void textsOnHomePageHaveProperValues(List<String> homePageTexts) {
        assertEquals(homePage.getHomePageTextsValues(), homePageTexts);
    }

    @Step("IFrame exists and is displayed on Home Page")
    public void homePageContainsIFrame() {
        assertTrue(homePage.getIframe().isDisplayed());
    }

    @Step("IFrame on Home Page has '{frameButtonValue}'")
    public void iframeOnHomePageContainsFrameButtonWithProperValue(String frameButtonValue) {
        assertEquals(homePage.getIframeButtonValue(), frameButtonValue);
    }

    @Step("All items in left side section on Home Page are displayed")
    public void checkAllItemsInLeftSideSectionOnHomePageAreDisplayed() {
        homePage.getLeftSideSectionMenu().getLeftSectionMenuItems()
            .forEach(element -> assertTrue(element.isDisplayed()));
    }

    @Step("Left side section on Home Page contains {numberOfItems} items")
    public void leftSideSectionOnHomePageContainsProperNumberOfItems(int numberOfItems) {
        assertEquals(homePage.getLeftSideSectionMenu().getNumberOfLeftSectionElements(), numberOfItems);
    }

    @Step("Items of left side section on Home Page have names: {names}")
    public void itemsOfLeftSideSectionOnHomePageHaveProperNames(List<String> names) {
        assertEquals(homePage.getLeftSideSectionMenu().getNamesOfLeftSectionElements(), names);
    }

    @Step("Logs on Different Elements Page are: {expectedLogs}")
    public void logsOnDifferentElementsPageEqualExpected(Set<String> expectedLogs) {
        List<String> actualLogs = differentElementsPage.getRightSideSectionMenu().getLogs();
        for (String log : actualLogs) {
            assertTrue(expectedLogs.contains(log.substring(9)), "Log is missing: " + log);
            expectedLogs.remove(log.substring(9));
        }
    }
}
