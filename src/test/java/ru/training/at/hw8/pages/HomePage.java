package ru.training.at.hw8.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.at.hw8.data.entities.User;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends AbstractPageWithHeaderSection {

    public void loginAs(User user) {
        headerSection.loginAs(user);
    }

}
