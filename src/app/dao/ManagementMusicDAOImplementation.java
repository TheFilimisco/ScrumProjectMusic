package app.dao;

import db.SQLiteConnector;
import models.dao.AlbumDAOImplementation;
import models.dao.ArtistDAOImplementation;
import models.dao.GenreDAOImplementation;
import models.dao.interfaces.GenericDAO;
import models.song.Album;
import models.song.Artist;
import models.song.Genre;
import models.song.Song;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class ManagementMusicDAOImplementation implements ManagementMusicDAO {
    static Connection conn = SQLiteConnector.getConnection();
    GenericDAO<Artist> artistDAO = new ArtistDAOImplementation();
    GenericDAO<Genre> genreDAO = new GenreDAOImplementation();
    GenericDAO<Album> albumDAO = new AlbumDAOImplementation();

    @Override
    public List<Song> searchSongByTitle(String title) throws SQLException {
        String query = "SELECT * FROM SONGS WHERE title_song LIKE ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, "%" + title + "%");
        ResultSet rs = ps.executeQuery();
        List<Song> songs = new ArrayList<>();
        while (rs.next()) {
            Song song = new Song();
            song.setIdSong(rs.getInt("id_song"));
            song.setTitleSong(rs.getString("title_song"));
            song.setDuration(rs.getInt("duration"));
            song.setArtist(artistDAO.readItem(rs.getInt("artist_id")));
            song.setGenre(genreDAO.readItem(rs.getInt("genre_id")));
            song.setAlbum(albumDAO.readItem(rs.getInt("album_id")));
            songs.add(song);
        }
        if (songs.isEmpty()) {
            return null;
        }
        return songs;
    }

    @Override
    public List<Song> searchSongByArtist(String artist) throws SQLException {
        String query = "SELECT S.* FROM SONGS S JOIN ARTISTS A ON (S.artist_id = A.id_artist)\n" +
                "WHERE A.name_artist LIKE ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, "%" + artist + "%");
        ResultSet rs = ps.executeQuery();
        List<Song> songs = new ArrayList<>();
        while (rs.next()) {
            Song song = new Song();
            song.setIdSong(rs.getInt("id_song"));
            song.setTitleSong(rs.getString("title_song"));
            song.setDuration(rs.getInt("duration"));
            song.setArtist(artistDAO.readItem(rs.getInt("artist_id")));
            song.setGenre(genreDAO.readItem(rs.getInt("genre_id")));
            song.setAlbum(albumDAO.readItem(rs.getInt("album_id")));
            songs.add(song);
        }
        if (songs.isEmpty()) {
            return null;
        }
        return songs;
    }

    @Override
    public List<Song> searchSongByAlbum(String album) throws SQLException {
        String query = "SELECT S.* FROM SONGS S JOIN ALBUMS A ON (S.album_id = A.id_album)\n" +
                "WHERE name_album LIKE ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, "%" + album + "%");
        ResultSet rs = ps.executeQuery();
        List<Song> songs = new ArrayList<>();
        while (rs.next()) {
            Song song = new Song();
            song.setIdSong(rs.getInt("id_song"));
            song.setTitleSong(rs.getString("title_song"));
            song.setDuration(rs.getInt("duration"));
            song.setArtist(artistDAO.readItem(rs.getInt("artist_id")));
            song.setGenre(genreDAO.readItem(rs.getInt("genre_id")));
            song.setAlbum(albumDAO.readItem(rs.getInt("album_id")));
            songs.add(song);
        }
        if (songs.isEmpty()) {
            return null;
        }
        return songs;
    }

    @Override
    public List<Song> searchSongByGenre(String genre) throws SQLException {
        String query = "SELECT S.* FROM SONGS S JOIN GENRES G ON (S.genre_id = G.id_genre)\n" +
                "WHERE name_genre LIKE  '%" + genre + "%'";
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        List<Song> songs = new ArrayList<>();
        while (rs.next()) {
            Song song = new Song();
            song.setIdSong(rs.getInt("id_song"));
            song.setTitleSong(rs.getString("title_song"));
            song.setDuration(rs.getInt("duration"));
            song.setArtist(artistDAO.readItem(rs.getInt("artist_id")));
            song.setGenre(genreDAO.readItem(rs.getInt("genre_id")));
            song.setAlbum(albumDAO.readItem(rs.getInt("album_id")));
            songs.add(song);
        }
        if (songs.isEmpty()) {
            return null;
        }
        return songs;
    }

    @Override
    public List<Song> searchSongByYear(String year) throws SQLException {
        String query = "SELECT S.* " +
                "FROM SONGS S JOIN ALBUMS A " +
                "ON (S.album_id = A.id_album) " +
                "WHERE strftime('%Y', A.releaseDate) = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, year);
        ResultSet rs = ps.executeQuery();
        List<Song> songs = new ArrayList<>();
        while (rs.next()) {
            Song song = new Song();
            song.setIdSong(rs.getInt("id_song"));
            song.setTitleSong(rs.getString("title_song"));
            song.setDuration(rs.getInt("duration"));
            song.setArtist(artistDAO.readItem(rs.getInt("artist_id")));
            song.setGenre(genreDAO.readItem(rs.getInt("genre_id")));
            song.setAlbum(albumDAO.readItem(rs.getInt("album_id")));
            songs.add(song);
        }
        if (songs.isEmpty()) {
            return null;
        }
        return songs;
    }

    @Override
    public void saveSongToHistory(LocalDateTime dateListened, Integer songId, Integer memberId) throws SQLException {
        String query = "INSERT INTO LISTENING_HISTORY (date_listened, song_id, member_id) " +
                "VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setTimestamp(1, Timestamp.valueOf(dateListened));
        ps.setInt(2, songId);
        ps.setInt(3, memberId);
        ps.executeUpdate();
    }
}
