package ru.training.at.hw8.components.enums;

import com.google.gson.annotations.SerializedName;

public enum Color {

    @SerializedName("Colors")
    COLORS(0),
    @SerializedName("Red")
    RED(1),
    @SerializedName("Green")
    GREEN(2),
    @SerializedName("Blue")
    BLUE(3),
    @SerializedName("Yellow")
    YELLOW(4);

    private final int index;

    Color(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}
