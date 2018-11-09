package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class StringSection extends AbstractSection {
    private List<String> listInfo = new ArrayList<>();

    public StringSection(String sectionInfo) {
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
