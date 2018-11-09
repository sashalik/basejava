package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ObjectSection extends AbstractSection {
    private List<ListOrganizations> listInfo = new ArrayList<>();

    public ObjectSection(String sectionInfo) {
        super(sectionInfo);
    }

    public void addInfo(ListOrganizations listOrganizations) {
        listInfo.add(listOrganizations);
    }

    @Override
    public String toString() {
        StringBuilder infoString = new StringBuilder(listInfo.size());
        for (ListOrganizations listOrganizations : listInfo) {
            infoString.append("* " + listOrganizations.toString());
        }
        return infoString.toString();
    }
}
