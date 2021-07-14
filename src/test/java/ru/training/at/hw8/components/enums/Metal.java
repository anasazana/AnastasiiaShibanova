package ru.training.at.hw8.components.enums;

public enum Metal {

    Metals(0),
    Gold(1),
    Silver(2),
    Bronze(3),
    Selen(4);

    private final int index;

    Metal(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }

}
