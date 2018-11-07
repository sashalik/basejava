package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ObjectSection extends Section {
    private List<ListInformation> listInfo = new ArrayList<>();

    public ObjectSection(String sectionInfo) {
        super(sectionInfo);
    }

    public void addInfo(ListInformation listInformation) {
        listInfo.add(listInformation);
    }

    @Override
    public String toString() {
        StringBuilder infoString = new StringBuilder(listInfo.size());
        for (ListInformation listInformation : listInfo) {
            infoString.append("* " + listInformation.toString());
        }
        return infoString.toString();
    }
}
