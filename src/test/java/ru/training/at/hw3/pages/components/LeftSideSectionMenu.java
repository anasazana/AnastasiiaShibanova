package ru.training.at.hw3.pages.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftSideSectionMenu {

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li/a/span")
    private List<WebElement> leftSectionMenuItems;

    public LeftSideSectionMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getLeftSectionMenuItems() {
        return leftSectionMenuItems;
    }

    public int getNumberOfLeftSectionElements() {
        return leftSectionMenuItems.size();
    }

    public List<String> getNamesOfLeftSectionElements() {
        return leftSectionMenuItems.stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    public void clickOnLeftSectionMenuItem(String menuItemName) {
        for (WebElement menuItem : leftSectionMenuItems) {
            if (menuItem.getText().equals(menuItemName)) {
                menuItem.click();
                break;
            }
        }
    }
}
