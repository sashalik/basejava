package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Resume implements Comparable<Resume> {
    private final String uuid;
    private final String fullName;
    private final Contacts contacts;
    private List<Section> sections = new ArrayList<>();

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.contacts = new Contacts();
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public Section getSection(SectionType sectionType) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getType().equals(sectionType)) {
                return sections.get(i);
            }
        }
        return null;
    }

    public void addContact(ContactType typeContact, String valueContact) {
        contacts.setValue(typeContact, valueContact);
    }

    public String getContact(ContactType typeContact) {
        return contacts.getValue(typeContact);
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