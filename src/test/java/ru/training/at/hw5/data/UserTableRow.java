package ru.training.at.hw5.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class UserTableRow {

    private WebElement number;
    private WebElement typeDropdown;
    private List<WebElement> types;
    private WebElement username;
    private WebElement description;
    private WebElement vipCheckBox;

    public UserTableRow() {
        types = new ArrayList<>();
    }

    public void setNumber(WebElement number) {
        this.number = number;
    }

    public void setTypeDropdown(WebElement typeDropdown) {
        this.typeDropdown = typeDropdown;
    }

    public void setTypes(List<WebElement> types) {
        this.types = types;
    }

    public void setUsername(WebElement username) {
        this.username = username;
    }

    public void setDescription(WebElement description) {
        this.description = description;
    }

    public void setVipCheckBox(WebElement vipCheckBox) {
        this.vipCheckBox = vipCheckBox;
    }

    public int getNumber() {
        return Integer.parseInt(number.getText());
    }

    public List<String> getTypesNames() {
        return types.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<WebElement> getTypes() {
        return types;
    }

    public String getUsername() {
        return username.getText();
    }

    public String getDescription() {
        return description.getText().replaceAll("\n", " ").replace(" Vip", "");
    }

    public WebElement getVipCheckBox() {
        return vipCheckBox;
    }

    public boolean numberIsDisplayed() {
        return number.isDisplayed();
    }

    public boolean nameIsDisplayed() {
        return username.isDisplayed();
    }

    public boolean descriptionIsDisplayed() {
        return description.isDisplayed();
    }

    public boolean typeDropdownIsDisplayed() {
        return typeDropdown.isDisplayed();
    }

    public boolean vipCheckBoxIsDisplayed() {
        return vipCheckBox.isDisplayed();
    }
}
