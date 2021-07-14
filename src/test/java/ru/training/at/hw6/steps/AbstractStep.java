package ru.training.at.hw6.steps;

import org.openqa.selenium.WebDriver;
import ru.training.at.hw6.pages.DifferentElementsPage;
import ru.training.at.hw6.pages.HomePage;

public abstract class AbstractStep {

    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }

}
