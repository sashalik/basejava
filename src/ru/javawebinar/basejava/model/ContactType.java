package ru.javawebinar.basejava.model;

public enum ContactType {
    PHONENUMBER("Тел:"),
    SKYPE("Skype:"),
    EMAIL("Почта:"),
    LINKEDIN("LinkedIn:"),
    GITHUB("GitHub:"),
    STACKOVERFLOW("Stackoverflow:"),
    HOMEPAGE("Домашняя страница:");

    private String desc;

    ContactType(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return desc;
    }
}
