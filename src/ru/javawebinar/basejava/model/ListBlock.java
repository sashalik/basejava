package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class ListBlock {
    private String nameBlock;
    private List<Block> listBlock = new ArrayList<>();

    public ListBlock(String nameBlock) {
        this.nameBlock = nameBlock;
    }

    public void addBlock(Block block) {
        this.listBlock.add(block);
    }

    @Override
    public String toString() {
        StringBuilder infoStringBlock = new StringBuilder(listBlock.size());
        for (Block b : listBlock) {
            infoStringBlock.append(b.toString() + "\n");
        }
        return nameBlock + "\n" + infoStringBlock.toString();
    }
}
