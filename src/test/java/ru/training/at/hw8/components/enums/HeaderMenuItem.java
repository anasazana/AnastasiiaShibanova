package ru.training.at.hw8.components.enums;

public enum HeaderMenuItem {

    Home("Home"),
    ContactForm("Contact Form"),
    Service("Service"),
    Support("Support"),
    Dates("Dates"),
    Search("Search"),
    ComplexTable("Complex Table"),
    SimpleTable("Simple Table"),
    UserTable("User Table"),
    TableWithPages("Table With Pages"),
    DifferentElements("Different Elements"),
    Performance("Performance"),
    MetalsAndColors("Metals & Colors");

    private String value;

    HeaderMenuItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
