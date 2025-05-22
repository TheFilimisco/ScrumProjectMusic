package app.service;

import app.dao.ManagementMusicDAOImplementation;
import models.song.Song;

import java.sql.SQLException;
import java.util.List;

public class ManagementMusicService extends ManagementMusicDAOImplementation {

    public List<Song> searchSongByTitle(String title) throws SQLException {
        return searchSongByTitle(title);
    }

}
