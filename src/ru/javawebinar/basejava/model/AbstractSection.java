package ru.javawebinar.basejava.model;

public abstract class AbstractSection {
    protected String sectionInfo;

    public AbstractSection(String sectionInfo) {
        this.sectionInfo = sectionInfo;
    }

    public String getInfo() {
        return sectionInfo;
    }
}
