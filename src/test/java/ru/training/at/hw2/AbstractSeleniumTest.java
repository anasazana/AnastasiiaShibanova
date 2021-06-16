package ru.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public abstract class AbstractSeleniumTest {

    protected WebDriver webDriver;

    @BeforeClass
    protected void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    protected void tearDown() {
        webDriver.quit();
    }

    @AfterClass
    protected void ultimateTearDown() {
        webDriver = null;
    }
}
