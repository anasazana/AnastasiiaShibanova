package ru.training.at.hw6.tests.ex2;


import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.Set;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw6.data.ExpectedValues;
import ru.training.at.hw6.tests.AbstractSeleniumTest;
import ru.training.at.hw6.utils.DifferentElementsLogCreator;

@Feature("Different Elements Page contents check")
@Story("Choose different elements")
public class DifferentElementsTest extends AbstractSeleniumTest {

    private final DifferentElementsLogCreator expectedLogsAccumulator = new DifferentElementsLogCreator();

    // 5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 3, description = "Open through the Home Page header menu Service -> Different Elements Page")
    public void openServiceDifferentElementsPageThroughHeaderMenuAndCheckIfItHasProperTitle() {
        actionStep.clickOnHeaderSectionServiceMenuItem(ExpectedValues.SERVICE_MENU_DIFFERENT_ELEMENTS_BUTTON_VALUE);
        assertionStep.differentElementsPageHasProperTitle(ExpectedValues.DIFFERENT_ELEMENTS_PAGE_TITLE);
    }

    // 6. Select checkboxes
    @Test(priority = 4, dataProvider = "selectedCheckBoxesData",
          description = "Select valid elements on Different Elements Page")
    public void selectElementCheckBoxes(String ... elementsToSelect) {
        actionStep.selectCheckBoxesOnDifferentElementsPage(elementsToSelect);
        for (String elementName : elementsToSelect) {
            expectedLogsAccumulator.addCheckBoxLog(elementName, true);
        }
    }

    // 7. Select radio
    @Test(priority = 5, dataProvider = "selectedRadioButtonData",
          description = "Select valid metal on Different Elements Page")
    public void selectMetalRadioButton(String metalToSelect) {
        actionStep.selectMetalRadioButtonOnDifferentElementsPage(metalToSelect);
        expectedLogsAccumulator.addRadioButtonLog(metalToSelect);
    }

    // 8. Select in dropdown
    @Test(priority = 6, dataProvider = "selectedDropdownMenuItemData",
          description = "Select valid color on Different Elements Page")
    public void selectColorDropdownMenuItem(String colorToSelect) {
        actionStep.openColorDropdownMenuOnDifferentElementsPage();
        actionStep.selectColorOnDifferentElementsPage(colorToSelect);
        expectedLogsAccumulator.addDropdownItemLog(colorToSelect);
    }

    // 9. Assert that
    // - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    // - for radio button there is a log row and value is corresponded to the status of radio button
    // - for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 7, description = "Check that Different Elements Page contains proper logs")
    public void assertLogsEqualExpected() {
        Set<String> expectedLogs = expectedLogsAccumulator.getLogs();
        assertionStep.logsOnDifferentElementsPageEqualExpected(expectedLogs);
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
