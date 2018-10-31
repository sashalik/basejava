package ru.javawebinar.basejava.model;

public class Contact {
    private String desc;
    private String link;

    public Contact(String desc, String link) {
        this.desc = desc;
        this.link = link;
    }

    @Override
    public String toString() {
        return desc + ' ' + link;
    }
}
