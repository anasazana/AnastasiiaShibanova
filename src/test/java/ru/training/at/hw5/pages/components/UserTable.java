package ru.training.at.hw5.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw5.data.UserTableRow;

import java.util.*;
import java.util.stream.Collectors;

public class UserTable {

    @FindBy(xpath = "//table[@id='user-table']/thead//th")
    private List<WebElement> userTableColumns;

    @FindBy(xpath = "//table[@id='user-table']/tbody/tr")
    private List<WebElement> tableRows;

    private Map<String, UserTableRow> userTableRows = new HashMap<>();

    private List<String> userNames = new ArrayList<>();

    public UserTable(WebDriver driver) {
        PageFactory.initElements(driver, this);
        createUsers();
    }

    private void createUsers() {
        tableRows.forEach(row -> {
            List<WebElement> rowElements = row.findElements(By.cssSelector("td"));

            WebElement numberColumn = rowElements.get(0);
            WebElement typeColumn = rowElements.get(1);
            WebElement nameColumn = rowElements.get(2);
            WebElement descColumn = rowElements.get(3);

            UserTableRow userTableRow = new UserTableRow();
            userTableRow.setNumber(numberColumn);
            userTableRow.setTypeDropdown(typeColumn);
            userTableRow.setTypes(typeColumn.findElements(By.cssSelector("option")));
            userTableRow.setUsername(nameColumn);
            userTableRow.setDescription(descColumn);
            userTableRow.setVipCheckBox(descColumn.findElement(By.cssSelector("div input")));
            userTableRows.put(nameColumn.getText(), userTableRow);
            userNames.add(nameColumn.getText());
        });
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public List<String> getUserTableColumns() {
        return userTableColumns.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public Map<String, UserTableRow> getUserTableRows() {
        return userTableRows;
    }

    public void selectVipCheckBox(String user) {
        userTableRows.get(user).getVipCheckBox().click();
    }

    public void vipCheckBoxIsSelected(String user) {
        userTableRows.get(user).getVipCheckBox().isSelected();
    }

    public List<WebElement> getTypesInDropdown(String user) {
        return userTableRows.get(user).getTypes();
    }

    public void selectTypeInDropdown(String user, String type) {
        Optional<WebElement> selectedTypeOptional = userTableRows.get(user).getTypes().stream()
                .filter(n -> n.getText().equalsIgnoreCase(type))
                .findFirst();
        if (selectedTypeOptional.isPresent()) {
            selectedTypeOptional.get().click();
        } else {
            System.out.println("There is no such type in dropdown");
        }
    }

}
