package model.song;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class Album {
    private String name;
    private LocalDate releaseDate;
    private ArrayList<Song> songs;

    public Album(String name, LocalDate releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
        songs = new ArrayList<>();
    }

    public void addSong(Song song){
        songs.add(song);
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
        return "Album {" + "\n" +
                "  Name: '" + name + '\'' + "\n" +
                "  Release Date: " + releaseDate + "\n" +
                "  Songs Count: " + (songs != null ? songs.size() : 0) + "\n" +
                "}";
    }
}
