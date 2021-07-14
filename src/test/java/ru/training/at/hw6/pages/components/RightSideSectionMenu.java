package ru.training.at.hw6.pages.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RightSideSectionMenu {

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logs;

    public RightSideSectionMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getLogs() {
        return logs.stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }

}
