package ru.training.at.hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import ru.training.at.hw8.components.HeaderSection;
import ru.training.at.hw8.components.enums.HeaderMenuItem;
import ru.training.at.hw8.data.entities.User;

public abstract class AbstractPageWithHeaderSection extends WebPage {

    @UI(".uui-header.dark-gray") public HeaderSection headerSection;

    public void logout() {
        headerSection.logout();
    }

    public void navigateThroughHeaderMenu(HeaderMenuItem item) {
        headerSection.navigateTo(item);
    }

    public boolean isUserLoggedIn(User user) {
        return headerSection.isUserLoggedIn(user);
    }

    public boolean isLoggedIn() {
        return headerSection.isLoggedIn();
    }
}
