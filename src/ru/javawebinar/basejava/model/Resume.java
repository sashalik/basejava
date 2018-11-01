package ru.javawebinar.basejava.model;

import java.util.*;

public class Resume implements Comparable<Resume> {
    private final String uuid;
    private final String fullName;
    private final Map<ContactType, ContactType> contacts = new HashMap();
    private final Map<SectionType, Section> sections = new HashMap();

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public void addSection(SectionType sectionType,Section section) {
        sections.put(sectionType, section);
    }

    public Section getSection(SectionType sectionType) {
        return sections.get(sectionType);
    }

    public void addContact(ContactType typeContact, String desc, String link) {
        contacts.put(typeContact, typeContact.getClass(desc, link));
    }

    public String getContact(ContactType typeContact) {
        return contacts.get(typeContact).toString();
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        if (!uuid.equals(resume.uuid)) {
            return false;
        }
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode() + fullName.hashCode();
    }

    @Override
    public String toString() {
        return uuid + " " + fullName;
    }

    @Override
    public int compareTo(Resume o) {
        if (fullName.equals(o.fullName)) {
            return uuid.compareTo(o.uuid);
        }
        return fullName.compareTo(o.fullName);
    }

}