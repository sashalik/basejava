package ru.javawebinar.basejava.model;

public class SimpleSection extends AbstractSection {

    public SimpleSection(String sectionInfo){
        super(sectionInfo);
    }

    @Override
    public String toString() {
        return sectionInfo+"\n";
    }
}
