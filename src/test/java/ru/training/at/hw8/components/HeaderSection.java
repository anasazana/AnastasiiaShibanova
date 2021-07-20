package ru.training.at.hw8.components;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import ru.training.at.hw8.components.enums.HeaderMenuItem;
import ru.training.at.hw8.data.entities.User;

@UI(".uui-header.dark-gray")
public class HeaderSection extends Section {

    @UI("ul.uui-navigation.nav.navbar-nav.m-l8 li a") public Menu headerMenu;
    @UI("ul.uui-navigation.navbar-nav.navbar-right") public UserSection userSection;

    public void navigateTo(HeaderMenuItem item) {
        headerMenu.select(item.getValue());
    }

    public void loginAs(User user) {
        userSection.login(user);
    }

    public void logout() {
        userSection.logout();
    }

    public boolean isUserLoggedIn(User user) {
        if (userSection.isUserNameDisplayed()) {
            return userSection.getUserName().equalsIgnoreCase(user.fullName);
        }
        return false;
    }

    public boolean isLoggedIn() {
        return userSection.isUserNameDisplayed();
    }

}
