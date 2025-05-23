package app.dao;

import models.song.Song;
import models.user.Member;

import java.sql.SQLException;
import java.util.List;

public interface ManagementMusicDAO extends MediaPlayerHistoryDAO {
    List<Song> searchSongByTitle(String title) throws SQLException;
    List<Song> searchSongByArtist(String artist) throws SQLException;
    List<Song> searchSongByAlbum(String album) throws SQLException;
    List<Song> searchSongByGenre(String genre) throws SQLException;
    List<Song> searchSongByYear(String year) throws SQLException;
}
