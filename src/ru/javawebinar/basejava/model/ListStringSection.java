package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ListStringSection extends Section {
    private List<String> listInfo = new ArrayList<>();

    public ListStringSection(String sectionInfo) {
        super(sectionInfo);
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
        return infoString.toString();
    }
}
