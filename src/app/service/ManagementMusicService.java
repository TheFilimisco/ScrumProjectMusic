package app.service;

import app.dao.ManagementMusicDAO;
import app.dao.ManagementMusicDAOImplementation;
import app.dao.MediaPlayerDAOImplementation;
import app.dao.MediaPlayerHistoryDAO;
import models.song.Song;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class ManagementMusicService {
    private final ManagementMusicDAO managementMusicDAO;
    private final MediaPlayerHistoryDAO mediaPlayerHistoryDAO;

    public ManagementMusicService() {
        managementMusicDAO = new ManagementMusicDAOImplementation();
        mediaPlayerHistoryDAO = new MediaPlayerDAOImplementation();
    }

    public void saveSongToHistory(LocalDateTime dateListened, Integer songId, Integer memberId) throws SQLException{
        mediaPlayerHistoryDAO.saveSongToHistory(dateListened, songId, memberId);
    }

    public List<Song> searchSongByTitle(String title) throws SQLException{
       return managementMusicDAO.searchSongByTitle(title);
    }

    public List<Song> searchSongByArtist(String artist) throws SQLException{
        return managementMusicDAO.searchSongByArtist(artist);
    }

    public List<Song> searchSongByAlbum(String album) throws SQLException{
        return managementMusicDAO.searchSongByAlbum(album);
    }

    public List<Song> searchSongByGenre(String genre) throws SQLException{
        return managementMusicDAO.searchSongByGenre(genre);
    }

    public List<Song> searchSongByYear(int year) throws SQLException{
        return managementMusicDAO.searchSongByYear(year);
    }


}
