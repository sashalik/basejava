package ru.javawebinar.basejava.model;

public class Contacts {
    private String phoneNumber = "";
    private String skype = "";
    private String email = "";
    private String linkedIn = "";
    private String gitHub = "";
    private String stackOverFlow = "";
    private String homePage = "";

    public void setValue(ContactType typeContact, String valueContact) {
        switch (typeContact) {
            case PHONENUMBER:
                this.phoneNumber = valueContact;
                break;
            case SKYPE:
                this.skype = valueContact;
                break;
            case EMAIL:
                this.email = valueContact;
                break;
            case LINKEDIN:
                this.linkedIn = valueContact;
                break;
            case GITHUB:
                this.gitHub = valueContact;
                break;
            case STACKOVERFLOW:
                this.stackOverFlow = valueContact;
                break;
            case HOMEPAGE:
                this.homePage = valueContact;
                break;
        }
    }

    public String getValue(ContactType typeContact) {
        switch (typeContact) {
            case PHONENUMBER:
                return "Тел: " + this.phoneNumber;
            case SKYPE:
                return "Skype: " + this.skype;
            case EMAIL:
                return "Почта: " + this.email;
            case LINKEDIN:
                return "LinkedIn: " + this.linkedIn;
            case GITHUB:
                return "GitHub: " + this.gitHub;
            case STACKOVERFLOW:
                return "Stackoverflow: " + this.stackOverFlow;
            case HOMEPAGE:
                return "Домашняя страница: " + this.homePage;
            default:
                return "Пусто";
        }
    }
}
