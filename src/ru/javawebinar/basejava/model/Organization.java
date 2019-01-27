package ru.javawebinar.basejava.model;

import ru.javawebinar.basejava.util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;

    private Link link;
    private List<Position> listPosition = new ArrayList<>();

    public Organization() {
    }

    public String getUrl(){
        return  "<a href='" + link.getName() + "'>" + link.getUrl() + "</a>";
    }

    public Organization(String name, String url, List<Position> listPositions) {
        link = new Link(name, url);
        this.listPosition = listPositions;
    }

    public Organization(String name, String url, Position... listPositions) {
        this(name, url, Arrays.asList(listPositions));
    }


    public Link getLink() {
        return link;
    }

    public List<Position> getListPosition() {
        return listPosition;
    }

    public void addPosition(Position position) {
        this.listPosition.add(position);
    }

    @Override
    public String toString() {
        StringBuilder infoStringBlock = new StringBuilder(listPosition.size());
        for (Position b : listPosition) {
            infoStringBlock.append(b.toString() );
        }
        return link.toString() + " " + infoStringBlock.toString();
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

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position implements Serializable {
        private static final long serialVersionUID = 1L;

        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate dateBeg;
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate dateEnd;
        private String title;
        private String description;

        public Position() {
        }

        public Position(LocalDate dateBeg, LocalDate dateEnd, String title, String description) {
            this.dateBeg = dateBeg;
            this.dateEnd = dateEnd;
            this.title = title;
            this.description = description == null ? "" : description;
        }

        public void setPeriod(LocalDate dateBeg, LocalDate dateEnd) {
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

        public LocalDate getDateBeg() {
            return dateBeg;
        }

        public LocalDate getDateEnd() {
            return dateEnd;
        }

        @Override
        public String toString() {
            return dateBeg + " " + dateEnd + " " + title + " " + description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return Objects.equals(dateBeg, position.dateBeg) &&
                    Objects.equals(dateEnd, position.dateEnd) &&
                    Objects.equals(title, position.title) &&
                    Objects.equals(description, position.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dateBeg, dateEnd, title, description);
        }
    }
}

