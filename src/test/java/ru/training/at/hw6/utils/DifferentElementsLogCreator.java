package ru.training.at.hw6.utils;

import java.util.HashSet;
import java.util.Set;

public class DifferentElementsLogCreator {

    private final Set<String> logsAccumulator;
    private int expectedNumberOfLogs;

    public DifferentElementsLogCreator() {
        logsAccumulator = new HashSet<>();
    }

    public void addCheckBoxLog(String item, boolean selected) {
        logsAccumulator.add(item + ": condition changed to " + selected);
        expectedNumberOfLogs++;
    }

    public void addRadioButtonLog(String selectedItem) {
        logsAccumulator.add("metal: value changed to " + selectedItem);
        expectedNumberOfLogs++;
    }

    public void addDropdownItemLog(String selectedItem) {
        logsAccumulator.add("Colors: value changed to " + selectedItem);
        expectedNumberOfLogs++;
    }

    public void incrementExpectedNumberOfLogs() {
        expectedNumberOfLogs++;
    }

    public int getExpectedNumberOfLogs() {
        return expectedNumberOfLogs;
    }

    public Set<String> getLogs() {
        return logsAccumulator;
    }

}
