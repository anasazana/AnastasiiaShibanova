package ru.training.at.hw8.test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.training.at.hw8.components.enums.HeaderMenuItem.MetalsAndColors;
import static ru.training.at.hw8.site.SiteJdi.homePage;
import static ru.training.at.hw8.site.SiteJdi.metalsAndColorsPage;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw8.data.DataParser;
import ru.training.at.hw8.data.entities.MetalsAndColorsData;
import ru.training.at.hw8.site.SiteJdi;


public class JdiSiteTest implements TestInit {

    @BeforeMethod
    public void setUp() {
        homePage.shouldBeOpened();
    }

    @AfterMethod
    public void tearDown() {
        SiteJdi.shouldBeLoggedOut();
    }

    @DataProvider
    public Object[][] metalsAndColorsFormTestData() throws IOException {
        return DataParser.getMetalsAndColorsTestData();
    }

    @Test(dataProvider = "metalsAndColorsFormTestData")
    public void metalsAndColorsFormTest(MetalsAndColorsData testData) {
        SiteJdi.loginAsDefaultUser();
        SiteJdi.navigateThroughHeaderMenu(MetalsAndColors);
        metalsAndColorsPage.shouldBeOpened();
        metalsAndColorsPage.fillMetalsAndColorsForm(testData);
        metalsAndColorsPage.submitMetalsAndColorsForm();
        assertThat(metalsAndColorsPage.actualResultEqualsExpected(testData));
    }

}
