package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected final String baseUrl = "https://jdi-testing.github.io/jdi-light/";

    protected String pageUrl;

    private final WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(baseUrl + pageUrl);
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
