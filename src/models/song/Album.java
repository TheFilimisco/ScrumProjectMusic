package models.song;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Album {
    private Integer idAlbum;
    private String nameAlbum;
    private LocalDateTime releaseDate;

    public Album(Integer idAlbum, String nameAlbum, LocalDateTime releaseDate) {
        this.idAlbum = idAlbum;
        this.nameAlbum = nameAlbum;
        this.releaseDate = releaseDate;
    }

    public Album() {
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Album{" +
                "idAlbum=" + idAlbum +
                ", nameAlbum='" + nameAlbum + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
