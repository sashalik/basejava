package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ListInformation {
    private String nameBlock;
    private List<Information> listInformation = new ArrayList<>();

    public ListInformation(String nameBlock) {
        this.nameBlock = nameBlock;
    }

    public void addBlock(Information information) {
        this.listInformation.add(information);
    }

    @Override
    public String toString() {
        StringBuilder infoStringBlock = new StringBuilder(listInformation.size());
        for (Information b : listInformation) {
            infoStringBlock.append(b.toString() + "\n");
        }
        return nameBlock + "\n" + infoStringBlock.toString();
    }
}
