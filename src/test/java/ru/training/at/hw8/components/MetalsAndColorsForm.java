package ru.training.at.hw8.components;

import static ru.training.at.hw8.components.enums.Vegetable.VEGETABLES;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import ru.training.at.hw8.components.enums.Element;
import ru.training.at.hw8.components.enums.Vegetable;
import ru.training.at.hw8.data.entities.MetalsAndColorsData;

@UI(".main-content")
public class MetalsAndColorsForm extends Section {

    @UI("#summary-block") public SummaryBlock summaryBlock;
    @UI("#elements-checklist p") public Checklist elements;
    @JDropdown(
            root = "#colors",
            value = ".filter-option pull-left",
            expand = ".caret",
            list = "li")
    public Dropdown colors;
    @JDropdown(
            root = "#metals",
            value = ".filter-option.pull-left",
            expand = ".caret",
            list = "li")
    public Dropdown metals;
    @JDropdown(
            root = "#vegetables",
            value = ".filter-option.pull-left",
            expand = ".caret",
            list = "a")
    public Dropdown vegetables;
    @UI("#submit-button") public Button submit;

    public void fill(MetalsAndColorsData data) {
        summaryBlock.calculateSummary(data.getSummary());
        selectElements(data.getElements());
        colors.select(data.getColor().name());
        metals.select(data.getMetals().name());
        selectVegetables(data.getVegetables());
    }

    private void selectVegetables(Vegetable[] vegetablesToSelect) {
        vegetables.select(VEGETABLES.name());
        for (Vegetable vegetable : vegetablesToSelect) {
            vegetables.select(vegetable.name());
        }
    }

    private void selectElements(Element[] elementsToSelect) {
        for (Element element : elementsToSelect) {
            elements.check(element.index());
        }
    }

    public void submit() {
        submit.click();
    }
}
