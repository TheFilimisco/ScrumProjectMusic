package models.song;

import java.util.*;

public class Genre {
    private Integer idGenre;
    private String nameGenre;
    private String description;

    public Genre(Integer idGenre, String nameGenre, String description) {
        this.idGenre = idGenre;
        this.nameGenre = nameGenre;
        this.description = description;
    }

    public Genre() {

    }

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public String getNameGenre() {
        return nameGenre;
    }

    public void setNameGenre(String nameGenre) {
        this.nameGenre = nameGenre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "idGenre=" + idGenre +
                ", nameGenre='" + nameGenre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}