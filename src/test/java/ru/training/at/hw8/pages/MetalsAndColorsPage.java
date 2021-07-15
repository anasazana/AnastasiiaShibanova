package ru.training.at.hw8.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import java.util.List;
import java.util.stream.Collectors;
import ru.training.at.hw8.components.HeaderSection;
import ru.training.at.hw8.components.MetalsAndColorsForm;
import ru.training.at.hw8.data.entities.MetalsAndColorsData;

@Url("/metals-colors")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends AbstractPageWithHeaderSection {

    @UI(".main-content") public MetalsAndColorsForm metalsAndColorsForm;
    @UI("ul.panel-body-list.results li") public WebList resultSectionValues;

    private List<String> getActualResult() {
        return resultSectionValues.stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
    }

    public boolean actualResultEqualsExpected(MetalsAndColorsData testData) {
        return getActualResult().containsAll(testData.getExpectedResult());
    }

    public void fillMetalsAndColorsForm(MetalsAndColorsData testData) {
        metalsAndColorsForm.fill(testData);
    }

    public void submitMetalsAndColorsForm() {
        metalsAndColorsForm.submit();
    }
}
