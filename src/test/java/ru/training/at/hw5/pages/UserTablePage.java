package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.pages.components.HeaderSectionMenu;
import ru.training.at.hw5.pages.components.LeftSideSectionMenu;
import ru.training.at.hw5.pages.components.RightSideSection;
import ru.training.at.hw5.pages.components.UserTable;

public class UserTablePage extends AbstractPage {

    private String userTablePageURL = "user-table";

    private HeaderSectionMenu headerSectionMenu;

    private LeftSideSectionMenu leftSideSectionMenu;

    private RightSideSection rightSideSection;

    private UserTable userTable;

    public UserTablePage(WebDriver driver) {
        super(driver);
        pageUrl = userTablePageURL;
        headerSectionMenu = new HeaderSectionMenu(driver);
        leftSideSectionMenu = new LeftSideSectionMenu(driver);
        rightSideSection = new RightSideSection(driver);
        userTable = new UserTable(driver);
    }

    public HeaderSectionMenu getHeaderSectionMenu() {
        return headerSectionMenu;
    }

    public LeftSideSectionMenu getLeftSideSectionMenu() {
        return leftSideSectionMenu;
    }

    public RightSideSection getRightSideSection() {
        return rightSideSection;
    }

    public UserTable getUserTable() { return userTable; }

}
