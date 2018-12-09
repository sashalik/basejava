package ru.javawebinar.basejava.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {
    private static final long serialVersionUID = 1L;

    private List<Organization> listOrganization;

    public OrganizationSection(Organization... listOrganization) {
        this.listOrganization = Arrays.asList(listOrganization);
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
