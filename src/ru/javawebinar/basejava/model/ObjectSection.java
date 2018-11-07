package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ObjectSection extends Section {
    private List<ListBlock> listInfo = new ArrayList<>();

    public ObjectSection(String sectionInfo) {
        super(sectionInfo);
    }

    public void addInfo(ListBlock listBlock) {
        listInfo.add(listBlock);
    }

    @Override
    public String toString() {
        StringBuilder infoString = new StringBuilder(listInfo.size());
        for (ListBlock listBlock : listInfo) {
            infoString.append("* " + listBlock.toString());
        }
        return infoString.toString();
    }
}
