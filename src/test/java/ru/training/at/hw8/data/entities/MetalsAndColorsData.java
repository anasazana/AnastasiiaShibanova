package ru.training.at.hw8.data.entities;

import com.epam.jdi.tools.DataClass;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import ru.training.at.hw8.components.enums.Color;
import ru.training.at.hw8.components.enums.Element;
import ru.training.at.hw8.components.enums.Metal;
import ru.training.at.hw8.components.enums.Vegetable;

public class MetalsAndColorsData extends DataClass<MetalsAndColorsData> {

    private Color color;
    private Metal metals;
    private Vegetable[] vegetables;
    private Element[] elements;
    private int[] summary;

    public Color getColor() {
        return color;
    }

    public Metal getMetals() {
        return metals;
    }

    public Vegetable[] getVegetables() {
        return vegetables;
    }

    public Element[] getElements() {
        return elements;
    }

    public int[] getSummary() {
        return summary;
    }

    public List<String> getExpectedResult() {
        List<String> expectedResult = new LinkedList<>();
        expectedResult.add(String.format("Summary: %d", summary[0] + summary[1]));
        expectedResult.add(String.format("Elements: %s",
                Arrays.stream(elements).map(Enum::name).collect(Collectors.joining(", "))));
        expectedResult.add(String.format("Color: %s", color.name()));
        expectedResult.add(String.format("Metal: %s", metals.name()));
        expectedResult.add(String.format("Vegetables: %s",
                Arrays.stream(vegetables).map(Enum::name).collect(Collectors.joining(", "))));
        return expectedResult;
    }

}
