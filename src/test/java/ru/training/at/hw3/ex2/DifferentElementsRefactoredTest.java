package ru.training.at.hw3.ex2;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw3.AbstractSeleniumRefactoredTest;
import ru.training.at.hw3.utils.DifferentElementsLogCreator;
import ru.training.at.hw3.pageObjects.DifferentElementsPage;
import ru.training.at.hw3.utils.ExpectedValues;
import ru.training.at.hw3.pageObjects.HeaderSectionMenu;

public class DifferentElementsRefactoredTest extends AbstractSeleniumRefactoredTest {

    private DifferentElementsPage differentElementsPage;
    private final DifferentElementsLogCreator expectedLogsAccumulator = new DifferentElementsLogCreator();

    // 5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 3)
    public void openServiceDifferentElementsPageThroughHeaderMenuAndCheckIfItHasProperTitle() {
        HeaderSectionMenu headerMenu = homePage.getHeaderSectionMenu();
        headerMenu.clickOnHeaderSectionMenuItem(ExpectedValues.HEADER_MENU_SERVICE_BUTTON_VALUE);
        headerMenu.clickOnServiceDropdownMenuItem(ExpectedValues.SERVICE_MENU_DIFFERENT_ELEMENTS_BUTTON_VALUE);

        differentElementsPage = new DifferentElementsPage(webDriver);
        String expectedTitle = ExpectedValues.DIFFERENT_ELEMENTS_PAGE_TITLE;
        assertCollector.assertEquals(webDriver.getTitle(), expectedTitle,
            "Page Title should be " + expectedTitle);
    }

    // 6. Select checkboxes
    @Test(priority = 4, dataProvider = "selectedCheckBoxesData")
    public void selectElementCheckBoxes(String ... elementsToSelect) {
        for (String elementName : elementsToSelect) {
            WebElement elementSelected = differentElementsPage.selectElement(elementName);
            if (elementSelected != null) {
                assertCollector.assertTrue(elementSelected.isDisplayed(),
                    "Element checkbox should be displayed.");
                assertCollector.assertTrue(differentElementsPage.getElementCheckBox(elementSelected).isSelected(),
                    elementName + " checkbox is not selected.");
                expectedLogsAccumulator.addCheckBoxLog(elementName, true);
            } else {
                assertCollector.fail(elementName + " checkbox does not exist.");
            }
        }
    }

    // 7. Select radio
    @Test(priority = 5, dataProvider = "selectedRadioButtonData")
    public void selectMetalRadioButton(String metalToSelect) {
        WebElement metalSelected = differentElementsPage.selectMetal(metalToSelect);
        if (metalSelected != null) {
            assertCollector.assertTrue(metalSelected.isDisplayed(), "Metal radio button should be displayed.");
            assertCollector.assertTrue(differentElementsPage.getMetalRadioButton(metalSelected).isSelected(),
                metalToSelect + " radio button is not selected.");
            expectedLogsAccumulator.addRadioButtonLog(metalToSelect);
        } else {
            assertCollector.fail(metalToSelect + " radio button does not exist.");
        }
    }

    // 8. Select in dropdown
    @Test(priority = 6, dataProvider = "selectedDropdownMenuItemData")
    public void selectColorDropdownMenuItem(String colorToSelect) {
        differentElementsPage.openColorDropdownMenu();
        WebElement colorSelected = differentElementsPage.selectColor(colorToSelect);
        if (colorSelected != null) {
            assertCollector.assertTrue(colorSelected.isDisplayed(), "Color option should be displayed.");
            assertCollector.assertTrue(colorSelected.isSelected(),
                colorToSelect + " color option is not selected.");
            expectedLogsAccumulator.addDropdownItemLog(colorToSelect);
        } else {
            assertCollector.fail(colorToSelect + " color option does not exist.");
        }
    }

    // 9. Assert that
    // - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    // - for radio button there is a log row and value is corresponded to the status of radio button
    // - for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 7)
    public void assertLogsEqualExpected() {
        Set<String> expectedLogs = expectedLogsAccumulator.getLogs();
        List<String> actualLogs = differentElementsPage.getRightSideSectionMenu().getLogs();
        for (String log : actualLogs) {
            assertCollector.assertTrue(expectedLogs.contains(log.substring(9)), "Log is missing: " + log);
        }
    }

    @DataProvider
    public Object[][] selectedCheckBoxesData() {
        return new Object[][]{
            {"Wind", "Water"}
        };
    }

    @DataProvider
    public Object[][] selectedRadioButtonData() {
        return new Object[][]{
            {"Selen"}
        };
    }

    @DataProvider
    public Object[][] selectedDropdownMenuItemData() {
        return new Object[][]{
            {"Yellow"}
        };
    }
    // 10. Close Browser
    // Browser is closed from inherited AbstractSeleniumTest.tearDown() method
}
