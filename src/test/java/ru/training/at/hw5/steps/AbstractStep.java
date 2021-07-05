package ru.training.at.hw5.steps;

import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.DifferentElementsPage;
import ru.training.at.hw5.pages.HomePage;
import ru.training.at.hw5.pages.UserTablePage;

public abstract class AbstractStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    protected AbstractStep() {
        WebDriver driver = TestContext.getInstance().getTestObject("driver");
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }
}
