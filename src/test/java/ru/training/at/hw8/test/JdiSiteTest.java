package ru.training.at.hw8.test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.training.at.hw8.components.enums.HeaderMenuItem.MetalsAndColors;
import static ru.training.at.hw8.site.SiteJdi.*;

import java.io.*;
import org.testng.annotations.*;
import ru.training.at.hw8.data.DataParser;
import ru.training.at.hw8.data.entities.MetalsAndColorsData;

public class JdiSiteTest implements TestInit {

    @BeforeMethod
    public void setUp() {
        homePage.shouldBeOpened();
    }

    @AfterMethod
    public void tearDown() {
        shouldBeLoggedOut();
    }

    @DataProvider
    public Object[][] metalsAndColorsFormTestData() throws IOException {
        return DataParser.getMetalsAndColorsTestData();
    }

    @Test(dataProvider = "metalsAndColorsFormTestData")
    public void metalsAndColorsFormTest(MetalsAndColorsData testData) {
        loginAsDefaultUser();
        navigateThroughHeaderMenu(MetalsAndColors);
        metalsAndColorsPage.shouldBeOpened();
        metalsAndColorsPage.fillMetalsAndColorsForm(testData);
        metalsAndColorsPage.submitMetalsAndColorsForm();
        assertThat(metalsAndColorsPage.actualResultEqualsExpected(testData));
    }
}
