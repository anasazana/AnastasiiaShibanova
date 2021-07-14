package ru.training.at.hw8.components.enums;

public enum Vegetable {
    Cucumber(0),
    Tomato(1),
    Vegetables(2),
    Onion(3);

    private final int index;

    Vegetable(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }

}
