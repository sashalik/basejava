package ru.javawebinar.basejava.model;

import java.util.Objects;

public class Organization {
    private String dateBeg;
    private String dateEnd;
    private String title;
    private String description;

    public void setPeriod(String dateBeg, String dateEnd) {
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriod() {
        return dateBeg.toString() + dateEnd.toString();
    }

    public String getBlockHeader() {
        return this.title;
    }

    public String getBlockDesc() {
        return this.description;
    }

    @Override
    public String toString() {
        return dateBeg + " - " + dateEnd + " " + title + "\n" + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(dateBeg, that.dateBeg) &&
                Objects.equals(dateEnd, that.dateEnd) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dateBeg, dateEnd, title, description);
    }
}
