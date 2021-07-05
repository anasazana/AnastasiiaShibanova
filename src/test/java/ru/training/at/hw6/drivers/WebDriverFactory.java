package ru.training.at.hw6.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class WebDriverFactory {

    private static final String CHROME = "CHROME";
    private static final String FIREFOX = "FIREFOX";
    private static final String OPERA = "OPERA";
    private static final String SAFARI = "SAFARI";

    private static final String LOCAL_DRIVER_TYPE = "local";
    private static final String REMOTE_DRIVER_TYPE = "remote";

    private WebDriverFactory() {
    }

    public static WebDriver createWebDriver(String browserName) {
        WebDriver driver;
        switch (browserName.toUpperCase()) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = createFirefox();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = createChrome();
                break;
            case OPERA:
                driver = createOpera();
                break;
            case SAFARI:
                driver = createSafari();
                break;
            default:
                driver = createChrome();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver createWebDriver(String driverType, String browserName) {
        if (driverType.equalsIgnoreCase(LOCAL_DRIVER_TYPE)) {
            return createWebDriver(browserName);
        } else if (driverType.equalsIgnoreCase(REMOTE_DRIVER_TYPE)) {
            return createRemoteWebDriver(browserName);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported driver type: %s.\n"
                + "Only remote and local types are supported.", driverType));
        }
    }

    private static WebDriver createRemoteWebDriver(String browserName) {
        Capabilities capabilities = null;
        if (browserName.equalsIgnoreCase(CHROME)) {
            capabilities = createChromeCapabilities();
        } else if (browserName.equalsIgnoreCase(FIREFOX)) {
            capabilities = createFirefoxCapabilities();
        } else if (browserName.equalsIgnoreCase(SAFARI)) {
            capabilities = createSafariCapabilities();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported browser: %s."
            + "Supported browsers are chrome and safari.", browserName));
        }
        try {
            return new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL");
        }
    }

    private static Capabilities createFirefoxCapabilities() {
        return new FirefoxOptions();
    }

    private static Capabilities createSafariCapabilities() {
        return new SafariOptions();
    }

    private static Capabilities createChromeCapabilities() {
        return new ChromeOptions();
    }

    private static WebDriver createFirefox() {
        return new FirefoxDriver();
    }

    private static WebDriver createChrome() {
        return new ChromeDriver();
    }

    private static WebDriver createOpera() {
        return new OperaDriver();
    }

    private static WebDriver createSafari() {
        return new SafariDriver();
    }
}
