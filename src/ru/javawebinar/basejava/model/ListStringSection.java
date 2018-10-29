package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ListStringSection extends Section {
    private List<String> listInfo = new ArrayList<>();

    public ListStringSection(SectionType sectionType, String sectionInfo) {
        super(sectionType, sectionInfo);
    }

    public void addInfo(String info) {
        listInfo.add(info);
    }

    @Override
    public String toString() {
        StringBuilder infoString = new StringBuilder(listInfo.size());
        for (String s : listInfo) {
            infoString.append("* " + s + "\n");
        }
        return sectionType.getTitle() + "\n" + infoString.toString();
    }
}
