package ru.training.at.hw5.steps;

import static org.testng.Assert.assertTrue;
import static org.testng.FileAssert.fail;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class WhenStep extends AbstractStep {

    @When("I select {listOfStrings} checkboxes on Different Elements Page")
    public void selectCheckboxesOnDifferentElementsPage(List<String> checkboxes) {
        for (String elementName : checkboxes) {
            WebElement elementSelected = differentElementsPage.selectElement(elementName);
            if (elementSelected != null) {
                assertTrue(elementSelected.isDisplayed());
                assertTrue(differentElementsPage.getElementCheckBox(elementSelected).isSelected());
            } else {
                fail(elementName + " checkbox does not exist.");
            }
        }
    }

    @ParameterType("\\[(.+)\\]")
    public List<String> listOfStrings(String strings) {
        return Arrays.stream(strings.split(","))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }

    @When("I select {string} radio button on Different Elements Page")
    public void selectRadioButtonOnDifferentElementsPage(String radiobutton) {
        WebElement metalSelected = differentElementsPage.selectMetal(radiobutton);
        if (metalSelected != null) {
            assertTrue(metalSelected.isDisplayed());
            assertTrue(differentElementsPage.getMetalRadioButton(metalSelected).isSelected());
        } else {
            fail(radiobutton + " radio button does not exist.");
        }
    }

    @When("I open color dropdown menu on Different Elements Page")
    public void openColorDropdownMenuOnDifferentElementsPage() {
        differentElementsPage.openColorDropdownMenu();
    }

    @When("I select {string} color in dropdown menu on Different Elements Page")
    public void selectColorInDropdownMenuOnDifferentElementsPage(String color) {
        WebElement colorSelected = differentElementsPage.selectColor(color);
        if (colorSelected != null) {
            assertTrue(colorSelected.isDisplayed());
            assertTrue(colorSelected.isSelected());
        } else {
            fail(color + " color option does not exist.");
        }
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckboxForUser(String user) {
        userTablePage.getUserTable().selectVipCheckBox(user);
    }
}
