package ru.training.at.hw6.drivers;

import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            String driverType = System.getProperty("driver.type") == null ? "local" : System.getProperty("driver.type");
            String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
            driver = WebDriverFactory.createWebDriver(driverType, browserName);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
