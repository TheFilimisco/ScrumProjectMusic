package model.song;

import java.time.LocalDate;
import java.util.ArrayList;

public class Album {
    private String name;
    private LocalDate releaseDate;
    private ArrayList<Song> songs;

    public Album(String name, LocalDate releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", songs=" + songs +
                '}';
    }
}
