package ru.training.at.hw8.components;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import ru.training.at.hw8.data.entities.User;

@UI("ul.uui-navigation.navbar-nav.navbar-right")
public class UserSection extends Section {

    @UI("#user-icon") public Icon userIcon;
    @UI("#user-name") public Label userName;
    @UI(".logout span") public Button logout;
    @UI("#login-form") public LoginForm loginForm;

    public String getUserName() {
        return userName.getValue();
    }

    public boolean userNameIsDisplayed() {
        return userName.isDisplayed();
    }

    public void openDropdownByClickingOnUserIcon() {
        userIcon.click();
    }

    public void login(User user) {
        openDropdownByClickingOnUserIcon();
        loginForm.login(user);
    }

    public void logout() {
        openDropdownByClickingOnUserIcon();
        logout.click();
    }

}
