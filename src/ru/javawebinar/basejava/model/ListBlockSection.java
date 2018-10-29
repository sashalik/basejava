package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ListBlockSection extends Section {
    private List<InfoBlock> listInfo = new ArrayList<>();

    public ListBlockSection(SectionType sectionType, String sectionInfo) {
        super(sectionType, sectionInfo);
    }

    public void addInfo(InfoBlock infoBlock) {
        listInfo.add(infoBlock);
    }

    @Override
    public String toString() {
        StringBuilder infoString = new StringBuilder(listInfo.size());
        for (InfoBlock infoBlock : listInfo) {
            infoString.append("* " + infoBlock.toString());
        }
        return sectionType.getTitle() + "\n" + infoString.toString();
    }
}
