package ru.javawebinar.basejava.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;

    private Link link;
    private List<Position> listPosition = new ArrayList<>();

    public Organization(String name, String url) {
        link = new Link(name, url);
    }

    public Organization(String name, String url, Position... listPositions) {
        link = new Link(name, url);
        this.listPosition = Arrays.asList(listPositions);
    }

    public void addPosition(Position position) {

        this.listPosition.add(position);
    }

    @Override
    public String toString() {
        StringBuilder infoStringBlock = new StringBuilder(listPosition.size());
        for (Position b : listPosition) {
            infoStringBlock.append(b.toString() + "\n");
        }
        return link.toString() + "\n" + infoStringBlock.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(link, that.link) &&
                Objects.equals(listPosition, that.listPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, listPosition);
    }

    public static class Position implements Serializable {
        private static final long serialVersionUID = 1L;

        private String dateBeg;
        private String dateEnd;
        private String title;
        private String description;

        public Position(String dateBeg, String dateEnd, String title, String description) {
            this.dateBeg = dateBeg;
            this.dateEnd = dateEnd;
            this.title = title;
            this.description = description;
        }

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
    }
}

