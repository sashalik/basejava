package ru.javawebinar.basejava.model;

public abstract class Section {
    protected String sectionInfo;

    public Section(String sectionInfo) {
        this.sectionInfo = sectionInfo;
    }

    public String getInfo() {
        return sectionInfo;
    }
}
