package data;

import model.song.Song;

import java.util.HashMap;

public class DataSongs {
    private static DataSongs instance;
    private HashMap<Integer,Song> dataSongs;

    public DataSongs() {
        dataSongs = new HashMap<>();
    }

    public static DataSongs getInstance() {
        if (instance == null) {
            instance = new DataSongs();
        }
        return instance;
    }

    public HashMap<Integer, Song> getDataSongs() {
        return dataSongs;
    }

    public void addSong(Song song) {
        dataSongs.put(song.getId(), song);
    }

    public void removeSong(int id) {
        dataSongs.remove(id);
    }

    public void showAllSongs(){
        for (Song song : dataSongs.values()) {
            System.out.println(song);
        }
    }

}
