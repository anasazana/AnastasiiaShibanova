package ru.training.at.hw4.pages;

import java.util.List;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw4.pages.components.HeaderSectionMenu;
import ru.training.at.hw4.pages.components.LeftSideSectionMenu;
import ru.training.at.hw4.pages.components.RightSideSectionMenu;

public class DifferentElementsPage extends AbstractPage {

    private final String differentElementsPageURL = "different-elements.html";

    private final HeaderSectionMenu headerSectionMenu;

    private final LeftSideSectionMenu leftSideSectionMenu;

    private final RightSideSectionMenu rightSideSectionMenu;

    @FindBy(css = "label[class=label-checkbox]")
    private List<WebElement> elementCheckBoxes;

    @FindBy(css = "label[class=label-radio]")
    private List<WebElement> metalRadioButtons;

    @FindBy(css = "select[class=uui-form-element]")
    private WebElement colorsDropdownToggle;

    @FindBy(css = "select[class=uui-form-element] option")
    private List<WebElement> colorOptions;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        pageUrl = differentElementsPageURL;
        headerSectionMenu = new HeaderSectionMenu(driver);
        leftSideSectionMenu = new LeftSideSectionMenu(driver);
        rightSideSectionMenu = new RightSideSectionMenu(driver);
    }

    public HeaderSectionMenu getHeaderSectionMenu() {
        return headerSectionMenu;
    }

    public LeftSideSectionMenu getLeftSideSectionMenu() {
        return leftSideSectionMenu;
    }

    public RightSideSectionMenu getRightSideSectionMenu() {
        return rightSideSectionMenu;
    }

    public int getNumberOfElements() {
        return elementCheckBoxes.size();
    }

    public WebElement selectElement(String element) {
        Optional<WebElement> selectedElementOptional = elementCheckBoxes.stream()
            .filter(checkBox -> checkBox.getText().contains(element))
            .findFirst();
        if (selectedElementOptional.isPresent()) {
            WebElement selectedElement = selectedElementOptional.get();
            selectedElement.click();
            return selectedElement;
        } else {
            return null;
        }
    }

    public WebElement getElementCheckBox(WebElement elementWithCheckBox) {
        return elementWithCheckBox.findElement(By.cssSelector("input[type=checkbox]"));
    }

    public int getNumberOfMetals() {
        return metalRadioButtons.size();
    }

    public WebElement selectMetal(String metal) {
        Optional<WebElement> selectedMetalOptional = metalRadioButtons.stream()
            .filter(button -> button.getText().contains(metal))
            .findFirst();
        if (selectedMetalOptional.isPresent()) {
            WebElement selectedMetal = selectedMetalOptional.get();
            selectedMetal.click();
            return selectedMetal;
        } else {
            return null;
        }
    }

    public WebElement getMetalRadioButton(WebElement metalWithRadioButton) {
        return metalWithRadioButton.findElement(By.cssSelector("input[type=radio]"));
    }

    public void openColorDropdownMenu() {
        colorsDropdownToggle.click();
    }

    public int getNumberOfColors() {
        return colorOptions.size();
    }

    public WebElement selectColor(String color) {
        Optional<WebElement> selectedColorOptional = colorOptions.stream()
            .filter(checkBox -> checkBox.getText().contains(color))
            .findFirst();
        if (selectedColorOptional.isPresent()) {
            WebElement selectedColor = selectedColorOptional.get();
            selectedColor.click();
            return selectedColor;
        } else {
            return null;
        }
    }

    public WebElement getColorSelector(WebElement colorWithSelector) {
        return colorWithSelector.findElement(By.cssSelector("input[type=radio]"));
    }

}
