package ru.training.at.hw8.components.enums;

import com.google.gson.annotations.SerializedName;

public enum Metal {

    @SerializedName("Metals")
    METALS(0),
    @SerializedName("Gold")
    GOLD(1),
    @SerializedName("Silver")
    SILVER(2),
    @SerializedName("Bronze")
    BRONZE(3),
    @SerializedName("Selen")
    SELEN(4);

    private final int index;

    Metal(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }

}
