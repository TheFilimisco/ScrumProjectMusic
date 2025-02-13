package model.song;

public class Song {
    private Integer id;
    private String title;
    private Album album;
    private Artist artist;
    private Genre genre;
    private int duration;

    public Song(String title, Album album, Artist artist, Genre genre, int duration) {
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", album=" + album.getName() +
                ", artist=" + artist.getName() +
                ", genre=" + genre.getName() +
                ", duration=" + duration +
                '}';
    }

}
