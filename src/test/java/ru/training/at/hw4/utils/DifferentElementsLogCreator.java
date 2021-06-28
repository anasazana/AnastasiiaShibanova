package ru.training.at.hw4.utils;

import java.util.HashSet;
import java.util.Set;

public class DifferentElementsLogCreator {

    private final Set<String> logsAccumulator;

    public DifferentElementsLogCreator() {
        logsAccumulator = new HashSet<>();
    }

    public void addCheckBoxLog(String item, boolean selected) {
        logsAccumulator.add(item + ": condition changed to " + selected);
    }

    public void addRadioButtonLog(String selectedItem) {
        logsAccumulator.add("metal: value changed to " + selectedItem);
    }

    public void addDropdownItemLog(String selectedItem) {
        logsAccumulator.add("Colors: value changed to " + selectedItem);
    }

    public Set<String> getLogs() {
        return logsAccumulator;
    }

}
