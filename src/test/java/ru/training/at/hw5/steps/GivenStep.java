package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openJdiGitHubSite() {
        homePage.open();
    }

    @Given("I login as user 'Roman Iovlev'")
    public void loginWithGivenUsernameData() throws IOException {
        Properties properties = new Properties();
        String projectPath = System.getProperty("user.dir");
        properties.load(new FileInputStream(projectPath + "/src/test/resources/config.properties"));

        homePage.openDropdownLoginForm();
        homePage.sendKeysToUsernameTextField(properties.getProperty("username"));
        homePage.sendKeysToPasswordTextField(properties.getProperty("password"));
        homePage.clickLoginButton();
    }

    @Given("I click on {string} button in Header")
    public void clickOnHeaderSectionMenuItem(String headerMenuItem) {
        homePage.getHeaderSectionMenu().clickOnHeaderSectionMenuItem(headerMenuItem);
    }

    @Given("I click on {string} button in Service dropdown")
    public void clickOnServiceDropdownMenuButton(String serviceDropdownMenuButton) {
        homePage.getHeaderSectionMenu().clickOnServiceDropdownMenuItem(serviceDropdownMenuButton);
    }

}
