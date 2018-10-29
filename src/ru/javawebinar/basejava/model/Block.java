package ru.javawebinar.basejava.model;

public class Block {
    private String dateBeg;
    private String dateEnd;
    private String blockHeader;
    private String blockDesc;

    public void setPeriod(String dateBeg, String dateEnd) {
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
    }

    public void setBlockHeader(String blockHeader) {
        this.blockHeader = blockHeader;
    }

    public void setBlockDesc(String blockDesc) {
        this.blockDesc = blockDesc;
    }

    public String getPeriod() {
        return dateBeg.toString() + dateEnd.toString();
    }

    public String getBlockHeader() {
        return this.blockHeader;
    }

    public String getBlockDesc() {
        return this.blockDesc;
    }

    @Override
    public String toString() {
        return dateBeg + " - " + dateEnd + " " + blockHeader + "\n" + blockDesc;
    }
}
