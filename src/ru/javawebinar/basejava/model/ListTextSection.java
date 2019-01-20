package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListTextSection extends AbstractSection {
    private static final long serialVersionUID = 1L;

    private List<String> listInfo = new ArrayList<>();

    public ListTextSection() {
    }

    public ListTextSection(String... listInfo) {
        this(Arrays.asList(listInfo));
    }

    public List<String> getListInfo() {
        return listInfo;
    }

    public ListTextSection(List<String> listInfo) {
        this.listInfo = listInfo;
    }

    @Override
    public String toString() {
        return String.join("\n", listInfo);
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
