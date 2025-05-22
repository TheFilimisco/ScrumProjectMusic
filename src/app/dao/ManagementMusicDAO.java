package app.dao;

import models.song.Song;
import models.user.Member;

import java.sql.SQLException;
import java.util.List;

public interface ManagementMusicDAO {
    public List<Song> searchSongByTitle(String title) throws SQLException;
    public List<Song> searchSongByArtist(String artist) throws SQLException;
    public List<Song> searchSongByAlbum(String album) throws SQLException;
    public List<Song> searchSongByGenre(String genre) throws SQLException;
    public List<Song> searchSongByYear(int year) throws SQLException;
}
