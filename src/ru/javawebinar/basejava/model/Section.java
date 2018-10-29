package ru.javawebinar.basejava.model;

public abstract class Section {
    protected SectionType sectionType;
    protected String sectionInfo;

    public Section(SectionType sectiontype, String sectionInfo){
        this.sectionType = sectiontype;
        this.sectionInfo = sectionInfo;
    }

    public String getTitle() {
        return sectionType.getTitle();
    }

    public SectionType getType() {
        return sectionType;
    }

    public String getInfo(){
        return sectionInfo;
    }
}
