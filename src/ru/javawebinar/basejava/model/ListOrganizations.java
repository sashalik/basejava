package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListOrganizations {
    private Link link;
    private List<Organization> listOrganization = new ArrayList<>();

    public ListOrganizations(String name, String url) {
        link = new Link(name, url);
    }

    public void addBlock(Organization organization) {
        this.listOrganization.add(organization);
    }

    @Override
    public String toString() {
        StringBuilder infoStringBlock = new StringBuilder(listOrganization.size());
        for (Organization b : listOrganization) {
            infoStringBlock.append(b.toString() + "\n");
        }
        return link.toString() + "\n" + infoStringBlock.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListOrganizations that = (ListOrganizations) o;
        return Objects.equals(link, that.link) &&
                Objects.equals(listOrganization, that.listOrganization);
    }

    @Override
    public int hashCode() {

        return Objects.hash(link, listOrganization);
    }
}

