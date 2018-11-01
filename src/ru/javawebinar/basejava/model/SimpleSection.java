package ru.javawebinar.basejava.model;

public class SimpleSection extends Section{

    public SimpleSection(String sectionInfo){
        super(sectionInfo);
    }

    @Override
    public String toString() {
        return sectionInfo+"\n";
    }
}
