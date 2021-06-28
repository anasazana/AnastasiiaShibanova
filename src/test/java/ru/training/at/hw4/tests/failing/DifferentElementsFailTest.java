package ru.training.at.hw4.tests.failing;


import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.Set;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw4.data.ExpectedValues;
import ru.training.at.hw4.tests.AbstractSeleniumTest;
import ru.training.at.hw4.utils.DifferentElementsLogCreator;

@Feature("Different Elements Page contents check")
@Story("Different Elements Page does not contain incorrect elements")
public class DifferentElementsFailTest extends AbstractSeleniumTest {

    private final DifferentElementsLogCreator expectedLogsAccumulator = new DifferentElementsLogCreator();

    // 5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 3)
    public void openServiceDifferentElementsPageThroughHeaderMenuAndCheckIfItHasProperTitle() {
        actionStep.clickOnHeaderSectionServiceMenuItem(ExpectedValues.SERVICE_MENU_DIFFERENT_ELEMENTS_BUTTON_VALUE);
        assertionStep.differentElementsPageHasProperTitle();
    }

    // 6. Select checkboxes
    @Test(priority = 4, dataProvider = "selectedCheckBoxesData")
    public void selectElementCheckBoxes(String ... elementsToSelect) {
        actionStep.selectCheckBoxesOnDifferentElementsPage(elementsToSelect);
        for (String elementName : elementsToSelect) {
            expectedLogsAccumulator.addCheckBoxLog(elementName, true);
        }
    }

    // 7. Select radio
    @Test(priority = 5, dataProvider = "selectedRadioButtonData")
    public void selectMetalRadioButton(String metalToSelect) {
        actionStep.selectMetalRadioButtonOnDifferentElementsPage(metalToSelect);
        expectedLogsAccumulator.addRadioButtonLog(metalToSelect);
    }

    // 8. Select in dropdown
    @Test(priority = 6, dataProvider = "selectedDropdownMenuItemData")
    public void selectColorDropdownMenuItem(String colorToSelect) {
        actionStep.openColorDropdownMenuOnDifferentElementsPage();
        actionStep.selectColorOnDifferentElementsPage(colorToSelect);
        expectedLogsAccumulator.addDropdownItemLog(colorToSelect);
    }

    // 9. Assert that
    // - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    // - for radio button there is a log row and value is corresponded to the status of radio button
    // - for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 7)
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
            {"Aluminum"}
        };
    }

    @DataProvider
    public Object[][] selectedDropdownMenuItemData() {
        return new Object[][]{
            {"Purple"}
        };
    }
    // 10. Close Browser
    // Browser is closed from inherited AbstractSeleniumTest.tearDown() method
}
