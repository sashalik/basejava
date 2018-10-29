package ru.javawebinar.basejava.model;

public class SimpleSection extends Section{

    public SimpleSection(SectionType sectionType, String sectionInfo){
        super(sectionType, sectionInfo);
    }

    @Override
    public String toString() {
        return sectionType.getTitle()+"\n"+sectionInfo+"\n";
    }
}
