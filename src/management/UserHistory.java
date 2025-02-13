package management;

import model.song.Artist;
import model.song.Genre;
import model.song.Song;

import java.util.HashMap;

public class UserHistory {
    private HashMap<Integer, Integer> songCounter;

    public UserHistory() {
        songCounter = new HashMap<Integer, Integer>();
    }

    public HashMap<Integer, Integer> getSongCounter() {
        return songCounter;
    }

    public void setSongCounter(HashMap<Integer, Integer> songCounter) {
        this.songCounter = songCounter;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "songCounter=" + songCounter +
                '}';
    }
}
