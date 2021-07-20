package ru.training.at.hw8.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.at.hw8.data.entities.User;
import ru.training.at.hw8.pages.AbstractPageWithHeaderSection;
import ru.training.at.hw8.pages.HomePage;
import ru.training.at.hw8.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {

    @Url("/index.html") public static HomePage homePage;
    @Url("/metals-colors.html") public static MetalsAndColorsPage metalsAndColorsPage;

    public static void loginAsDefaultUser() {
        homePage.loginAs(User.DEFAULT_USER);
    }

    public static void shouldBeLoggedOut(AbstractPageWithHeaderSection page) {
        if (page.isLoggedIn()) {
            page.logout();
        }
    }

}
