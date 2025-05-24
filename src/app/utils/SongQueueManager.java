package app.utils;

import models.dao.SongDAOImplementation;
import models.dao.interfaces.GenericDAO;
import models.song.Song;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SongQueueManager {
    private final GenericDAO<Song> songDAO;
    private Map<Integer, Song> songsQueue;
    private int currentIndex = 0;

    public SongQueueManager(GenericDAO<Song> songDAO) {
        this.songDAO = songDAO;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public Map<Integer, Song> getSongsQueue() {
        return songsQueue;
    }


    public void loadSongsOfDB() throws SQLException {
        List<Song> getAllSongs = songDAO.getItems();
        songsQueue = new LinkedHashMap<>();

        int index = 0;
        for (Song song : getAllSongs) {
            songsQueue.put(index++, song);
        }
    }

    public void loadSingleSong(Song song) throws SQLException {
        songsQueue = new LinkedHashMap<>();
        songsQueue.put(1, song);
        loadSongsOfDB();
    }

    public Song getCurrentSong() throws SQLException {
        return songsQueue.get(currentIndex);
    }


    // Next Circular Navigation to loop back to the first song after the last one

    public void nextSong() throws SQLException {
        currentIndex = (currentIndex + 1) % songsQueue.size();
    }

    // if you is in first song and put previous next until to last song.
    public void previousSong() throws SQLException {
        currentIndex = (currentIndex == 0) ?  songsQueue.size() - 1 : currentIndex - 1;
    }

}
