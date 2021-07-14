package ru.training.at.hw8.site;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import ru.training.at.hw8.components.HeaderSection;
import ru.training.at.hw8.components.enums.HeaderMenuItem;
import ru.training.at.hw8.data.entities.User;
import ru.training.at.hw8.pages.HomePage;
import ru.training.at.hw8.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {

    @Url("/index.html") public static HomePage homePage;
    @Url("/metals-colors.html") public static MetalsAndColorsPage metalsAndColorsPage;
    @UI(".uui-header.dark-gray") public static HeaderSection headerSection;

    public static void loginAsDefaultUser() {
        headerSection.loginAs(User.DEFAULT_USER);
    }

    public static void logout() {
        headerSection.logout();
    }

    public static void navigateThroughHeaderMenu(HeaderMenuItem item) {
        headerSection.navigateTo(item);
    }

    public static void shouldBeLoggedOut() {
        if (headerSection.userSection.userNameIsDisplayed()) {
            headerSection.logout();
        }
    }

}
