package ru.training.at.hw6.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw6.pages.components.HeaderSectionMenu;
import ru.training.at.hw6.pages.components.LeftSideSectionMenu;

public class HomePage extends AbstractPage {

    private final String homePageURL = "index.html";

    private final HeaderSectionMenu headerSectionMenu;

    private final LeftSideSectionMenu leftSideSectionMenu;

    @FindBy(xpath = "//li[@class='dropdown uui-profile-menu']/a[@class='dropdown-toggle']")
    private WebElement loginDropdownToggle;

    @FindBy(css = "input[id=name]")
    private WebElement usernameTextField;

    @FindBy(css = "input[id=password]")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement usernameLabel;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "frame-button")
    private WebElement iframeButton;

    @FindBy(css = "div[class=benefit-icon]")
    private List<WebElement> homePageImages;

    @FindBy(css = "span[class=benefit-txt]")
    private List<WebElement> homePageTexts;

    public HomePage(WebDriver driver) {
        super(driver);
        pageUrl = "index.html";
        headerSectionMenu = new HeaderSectionMenu(driver);
        leftSideSectionMenu = new LeftSideSectionMenu(driver);
    }

    public HeaderSectionMenu getHeaderSectionMenu() {
        return headerSectionMenu;
    }

    public LeftSideSectionMenu getLeftSideSectionMenu() {
        return leftSideSectionMenu;
    }

    public void openDropdownLoginForm() {
        loginDropdownToggle.click();
    }

    public void sendKeysToUsernameTextField(String username) {
        usernameTextField.sendKeys(username);
    }

    public void sendKeysToPasswordTextField(String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public WebElement getUsernameLabel() {
        return usernameLabel;
    }

    public String getUsernameLabelText() {
        return usernameLabel.getText();
    }

    public WebElement getIframe() {
        return iframe;
    }

    public String getIframeButtonValue() {
        return iframeButton.getAttribute("value");
    }

    public int getNumberOfHomePageImages() {
        return homePageImages.size();
    }

    public List<WebElement> getHomePageImages() {
        return homePageTexts;
    }

    public int getNumberOfHomePageTexts() {
        return homePageTexts.size();
    }

    public List<WebElement> getHomePageTexts() {
        return homePageTexts;
    }

    public List<String> getHomePageTextsValues() {
        return homePageTexts.stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }


}
