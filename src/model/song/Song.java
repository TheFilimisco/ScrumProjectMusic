package model.song;

import java.util.Objects;

public class Song {
    private Integer id;
    private String title;
    private Album album;
    private Genre genre;
    private int duration;
    private static int counterSong = 0;

    public Song(String title, Album album, Genre genre, int duration) {
        id = counterSong++;
        this.title = title;
        this.album = album;
        this.genre = genre;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", album=" + album.getName() +
                ", genre=" + genre.getName() +
                ", duration=" + duration +
                '}';
    }
}
