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
    private String link;

    ContactType(String desc) {
        this.desc = desc;
    }

    ContactType(String desc, String link) {
        this.desc = desc;
        this.link = link;
    }

    public String getTitle() {
        return desc + " " + link;
    }
}
