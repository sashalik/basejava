package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {
    private List<ListOrganizations> listInfo = new ArrayList<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return Objects.equals(listInfo, that.listInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listInfo);
    }
}
