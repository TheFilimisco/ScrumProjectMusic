package management;

import model.song.Artist;
import model.song.Genre;
import model.song.Song;

import java.util.HashMap;

public class UserHistory {
    private HashMap<Song, Integer> songCounter;
    private HashMap<Genre, Integer> genreCounter;
    private HashMap<Artist, Integer> artistCounter;

    public UserHistory() {
        songCounter = new HashMap<Song, Integer>();
        genreCounter = new HashMap<Genre, Integer>();
        artistCounter = new HashMap<Artist, Integer>();
    }

    public HashMap<Song, Integer> getSongCounter() {
        return songCounter;
    }

    public void setSongCounter(HashMap<Song, Integer> songCounter) {
        this.songCounter = songCounter;
    }

    public HashMap<Genre, Integer> getGenreCounter() {
        return genreCounter;
    }

    public void setGenreCounter(HashMap<Genre, Integer> genreCounter) {
        this.genreCounter = genreCounter;
    }

    public HashMap<Artist, Integer> getArtistCounter() {
        return artistCounter;
    }

    public void setArtistCounter(HashMap<Artist, Integer> artistCounter) {
        this.artistCounter = artistCounter;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "songCounter=" + songCounter +
                ", genreCounter=" + genreCounter +
                ", artistCounter=" + artistCounter +
                '}';
    }
}
