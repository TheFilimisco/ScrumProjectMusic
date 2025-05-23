package admin.dao;

import models.song.Song;

import java.sql.SQLException;
import java.util.List;

public interface AdminSongDAO {
    public void addSong(Song song) throws SQLException;
    public void updateSong(Song song) throws SQLException;
    public void deleteSong(Integer idSong) throws SQLException;
    public List<Song> getSongs() throws SQLException;
}
