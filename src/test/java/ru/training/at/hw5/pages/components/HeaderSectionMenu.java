package ru.training.at.hw5.pages.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderSectionMenu {

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a")
    private List<WebElement> headerSectionMenuItems;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//ul[@class='dropdown-menu']/li")
    private List<WebElement> serviceDropdownMenuItems;

    public HeaderSectionMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnHeaderSectionMenuItem(String menuItemName) {
        for (WebElement menuItem : headerSectionMenuItems) {
            if (menuItem.getText().equalsIgnoreCase(menuItemName)) {
                menuItem.click();
                break;
            }
        }
    }

    public List<WebElement> getHeaderSectionMenuItems() {
        return headerSectionMenuItems;
    }

    public int getNumberOfHeaderSectionMenuItems() {
        return headerSectionMenuItems.size();
    }

    public List<String> getNamesOfHeaderSectionMenuItems() {
        return headerSectionMenuItems.stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    public void clickOnServiceDropdownMenuItem(String serviceMenuItemName) {
        for (WebElement menuItem : serviceDropdownMenuItems) {
            if (menuItem.getText().equalsIgnoreCase(serviceMenuItemName)) {
                menuItem.click();
                break;
            }
        }
    }


}
