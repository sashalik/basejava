package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListTextSection extends AbstractSection {
    private List<String> listInfo = new ArrayList<>();

    public ListTextSection(){

    }

    public ListTextSection(String... listInfo) {
        this(Arrays.asList(listInfo));
    }

    public ListTextSection(List<String> listInfo) {
        this.listInfo = listInfo;
    }

    /*public void addInfo(String info) {
        this.listInfo.add(info);
    }*/

    @Override
    public String toString() {
        StringBuilder infoString = new StringBuilder(listInfo.size());
        for (String s : listInfo) {
            infoString.append("* " + s + "\n");
        }
        return infoString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListTextSection that = (ListTextSection) o;
        return Objects.equals(listInfo, that.listInfo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(listInfo);
    }
}
