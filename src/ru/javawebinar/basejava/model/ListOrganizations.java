package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ListOrganizations {
    private String nameBlock;
    private List<Organization> listOrganization = new ArrayList<>();

    public ListOrganizations(String nameBlock) {
        this.nameBlock = nameBlock;
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
        return nameBlock + "\n" + infoStringBlock.toString();
    }
}
