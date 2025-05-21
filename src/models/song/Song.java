package models.song;

import java.util.Objects;

public class Song {
    private Integer idSong;
    private String titleSong;
    private Integer duration;
    private Artist artist;
    private Genre genre;
    private Album album;

    public Song(Integer idSong, String titleSong, Integer duration, Artist artist, Genre genre, Album album) {
        this.idSong = idSong;
        this.titleSong = titleSong;
        this.duration = duration;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
    }

    public Song(Integer idSong, String titleSong, Integer duration, Integer artist, Integer genre, Integer album) {
        this.idSong = idSong;
        this.titleSong = titleSong;
        this.duration = duration;
        this.artist = new Artist();
        this.artist.setIdArtist(artist);
        this.genre = new Genre();
        this.genre.setIdGenre(genre);
        this.album = new Album();
        this.album.setIdAlbum(album);
    }

    public Song() {
    }

    public Integer getIdSong() {
        return idSong;
    }

    public void setIdSong(Integer idSong) {
        this.idSong = idSong;
    }

    public String getTitleSong() {
        return titleSong;
    }

    public void setTitleSong(String titleSong) {
        this.titleSong = titleSong;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Song{" +
                "idSong=" + idSong +
                ", titleSong='" + titleSong + '\'' +
                ", duration='" + duration + '\'' +
                ", artist=" + artist +
                ", genre=" + genre +
                ", album=" + album +
                '}';
    }
}
