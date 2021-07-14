package ru.training.at.hw8.components.enums;

public enum Color {

    Colors(0),
    Red(1),
    Green(2),
    Blue(3),
    Yellow(4);

    private final int index;

    Color(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}
