package model.user.memberuser;

import model.song.Album;
import model.song.Artist;
import model.song.Genre;
import model.song.Song;

import java.util.HashMap;

public class UserHistory {
    private HashMap<Integer, Integer> songCounter;
    private HashMap<Album, Integer> albumCounter;
    private HashMap<Artist, Integer> artistCounter;
    private HashMap<Genre, Integer> genreCounter;


    public HashMap<Integer, Integer> getSongCounter() {
        return songCounter;
    }

    public void setSongCounter(HashMap<Integer, Integer> songCounter) {
        this.songCounter = songCounter;
    }

    public HashMap<Album, Integer> getAlbumCounter() {
        return albumCounter;
    }

    public void setAlbumCounter(HashMap<Album, Integer> albumCounter) {
        this.albumCounter = albumCounter;
    }

    public HashMap<Artist, Integer> getArtistCounter() {
        return artistCounter;
    }

    public void setArtistCounter(HashMap<Artist, Integer> artistCounter) {
        this.artistCounter = artistCounter;
    }

    public HashMap<Genre, Integer> getGenreCounter() {
        return genreCounter;
    }

    public void setGenreCounter(HashMap<Genre, Integer> genreCounter) {
        this.genreCounter = genreCounter;
    }

    public UserHistory() {
        songCounter = new HashMap<>();
        albumCounter = new HashMap<>();
        artistCounter = new HashMap<>();
        genreCounter = new HashMap<>();
    }



    @Override
    public String toString() {
        return "UserHistory{" +
                "songCounter=" + songCounter +
                ", albumCounter=" + albumCounter +
                ", artistCounter=" + artistCounter +
                ", genreCounter=" + genreCounter +
                '}';
    }
}
