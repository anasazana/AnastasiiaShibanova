package ru.training.at.hw8.components.enums;

public enum Element {

    Water(1),
    Earth(2),
    Wind(3),
    Fire(4);

    private final int index;

    Element(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}
