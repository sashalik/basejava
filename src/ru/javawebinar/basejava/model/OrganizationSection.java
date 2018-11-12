package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {
    private List<Organization> listOrganization = new ArrayList<>();

    public void addOrganization(Organization organization) {
        listOrganization.add(organization);
    }

    @Override
    public String toString() {
        StringBuilder infoString = new StringBuilder(listOrganization.size());
        for (Organization organization : listOrganization) {
            infoString.append("* " + organization.toString());
        }
        return infoString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return Objects.equals(listOrganization, that.listOrganization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOrganization);
    }
}
