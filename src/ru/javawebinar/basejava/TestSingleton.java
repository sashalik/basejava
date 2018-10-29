package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.ContactType;
import ru.javawebinar.basejava.model.Contacts;

public class TestSingleton {
    private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance.ordinal());
        /*for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }*/
        Contacts c = new Contacts();

        c.setValue(ContactType.PHONENUMBER,"00-000-00");
        c.setValue(ContactType.SKYPE,"sashal");
        c.setValue(ContactType.EMAIL,"sashal@rambler.ru");

        for (ContactType type : ContactType.values()) {
            System.out.println(c.getValue(type));
        }


    }

    public enum Singleton {
        INSTANCE
    }
}
