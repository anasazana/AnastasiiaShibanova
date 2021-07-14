package ru.training.at.hw5.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import ru.training.at.hw5.data.ExpectedValues;
import ru.training.at.hw5.data.UserTableRow;

public class ThenStep extends AbstractStep {

    @Then("Right Section on Different Elements Page contains proper logs")
    public void rightSectionOnDifferentElementsPageContainsProperLogs() {
        List<String> expectedLogs = ExpectedValues.EXPECTED_LOGS;
        List<String> actualLogs = differentElementsPage.getRightSideSection().getLogs().stream()
                .map(s -> s.substring(9))
                .collect(Collectors.toList());
        assertThat("Actual logs differ from expected",
                actualLogs.containsAll(expectedLogs) && actualLogs.size() == expectedLogs.size());
    }

    @Then("'User Table' page should be opened")
    public void userTablePageIsOpened() {
        assertThat("User Table page should be opened.",
                userTablePage.getTitle().equals(ExpectedValues.USER_TABLE_PAGE_TITLE));
    }

    @Then("{int} Numbers should be displayed in Users Table on User Table Page")
    public void thereIsProperNumberOfNumbersDisplayedInUserTableOnUserTablePage(int numberOfNumbers) {
        Map<String, UserTableRow> mapOfUsers = userTablePage.getUserTable().getUserTableRows();
        assertThat("There should be " + numberOfNumbers + " numbers displayed in user table",
                mapOfUsers.size() == numberOfNumbers);
        for (UserTableRow user : mapOfUsers.values()) {
            assertThat("All numbers should be displayed in user table", user.numberIsDisplayed());
        }
    }

    @Then("{int} Type Dropdowns should be displayed in Users Table on User Table Page")
    public void thereIsProperNumberOfTypeDropdownsDisplayedInUserTableOnUserTablePage(int numberOfDropdowns) {
        Map<String, UserTableRow> mapOfUsers = userTablePage.getUserTable().getUserTableRows();
        assertThat("There should be " + numberOfDropdowns + " dropdowns displayed in user table",
                mapOfUsers.size() == numberOfDropdowns);
        for (UserTableRow user : mapOfUsers.values()) {
            assertThat("All type dropdowns should be displayed in user table", user.typeDropdownIsDisplayed());
        }
    }

    @Then("{int} Usernames should be displayed in Users Table on User Table Page")
    public void thereIsProperNumberOfUsernamesDisplayedInUserTableOnUserTablePage(int numberOfUsernames) {
        Map<String, UserTableRow> mapOfUsers = userTablePage.getUserTable().getUserTableRows();
        assertThat("There should be " + numberOfUsernames + " usernames displayed in user table",
                mapOfUsers.size() == numberOfUsernames);
        for (UserTableRow user : mapOfUsers.values()) {
            assertThat("All usernames should be displayed in user table", user.nameIsDisplayed());
        }
    }

    @Then("{int} Description texts under images should be displayed in Users Table on User Table Page")
    public void thereIsProperNumberOfDescriptionsDisplayedInUserTableOnUserTablePage(int numberOfDescriptions) {
        Map<String, UserTableRow> mapOfUsers = userTablePage.getUserTable().getUserTableRows();
        assertThat("There should be " + numberOfDescriptions + " descriptions displayed in user table",
                mapOfUsers.size() == numberOfDescriptions);
        for (UserTableRow user : mapOfUsers.values()) {
            assertThat("All descriptions should be displayed in user table", user.descriptionIsDisplayed());
        }
    }

    @Then("{int} checkboxes should be displayed in Users Table on User Table Page")
    public void thereIsProperNumberOfCheckboxesDisplayedInUserTableOnUserTablePage(int numberOfCheckboxes) {
        Map<String, UserTableRow> mapOfUsers = userTablePage.getUserTable().getUserTableRows();
        assertThat("There should be " + numberOfCheckboxes + " checkboxes displayed in user table",
                mapOfUsers.size() == numberOfCheckboxes);
        for (UserTableRow user : mapOfUsers.values()) {
            assertThat("All checkboxes should be displayed in user table", user.vipCheckBoxIsDisplayed());
        }
    }

    @Then("User table should contain following values:")
    public void userTableContainsProperValues(DataTable dataTable) {
        List<List<String>> expectedData = dataTable.asLists(String.class);
        List<List<String>> actualData = userTablePage.getUserTable().getUserTableRows()
                .values()
                .stream()
                .map(value -> {
                    List<String> list = new ArrayList<>();
                    list.add(Integer.toString(value.getNumber()));
                    list.add(value.getUsername());
                    list.add(value.getDescription());
                    return list;
                })
                .sorted(Comparator.comparingInt(n -> Integer.parseInt(n.get(0))))
                .collect(Collectors.toList());
        for (int i = 0; i < expectedData.size() - 1; i++) {
            assertThat("User table should contain expected values",
                    expectedData.get(i + 1).equals(actualData.get(i)));
        }
    }

    @Then("Droplist should contain values in column Type for user {string}")
    public void droplistForUserContainsProperValues(String user, DataTable table) {
        List<String> expectedTypes = table.asList(String.class);
        List<String> actualTypes = userTablePage.getUserTable().getTypesInDropdown(user)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat("Droplist should contain proper values", expectedTypes.containsAll(actualTypes));
    }

    @Then("1 log row has {string} text in log section")
    public void logsContainProperLogRow(String log) {
        List<String> actualLogs = differentElementsPage.getRightSideSection().getLogs().stream()
                .map(s -> s.substring(9))
                .collect(Collectors.toList());
        assertThat("There should be 1 log row in log section", actualLogs.size() == 1);
        assertThat("Log section should contain " + log, actualLogs.contains(log));
    }
}
