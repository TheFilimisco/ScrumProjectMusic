package model.song;

import java.time.LocalDate;
import java.util.*;

public class Album {
    private String name;
    private LocalDate releaseDate;
    private Artist artist;
    private List<Song> songs;

    public Album(String name, LocalDate releaseDate, Artist artist) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.artist = artist;
        songs = new ArrayList<Song>();

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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSongToAlbum(Song song){
        if (!songs.contains(song)){
            songs.add(song);
            return;
        }
        throw new IllegalStateException("This Song exist in this Album: " + song.getTitle());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(name, album.name) && Objects.equals(releaseDate, album.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, releaseDate);
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", artist=" + artist.getName() +
                '}';
    }

}
