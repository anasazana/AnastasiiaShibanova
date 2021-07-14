package ru.training.at.hw8.test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw8.site.SiteJdi;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        killAllSeleniumDrivers();
        initElements(SiteJdi.class);
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
