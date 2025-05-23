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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class ManagementMusicDAOImplementation implements ManagementMusicDAO {
    static Connection conn = SQLiteConnector.getConnection();
    GenericDAO<Artist> artistDAO = new ArtistDAOImplementation();
    GenericDAO<Genre> genreDAO = new GenreDAOImplementation();
    GenericDAO<Album> albumDAO = new AlbumDAOImplementation();

    @Override
    public List<Song> searchSongByTitle(String title) throws SQLException {
        String query = "SELECT * FROM song WHERE title_song LIKE '%" + title + "%'";
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
    public List<Song> searchSongByArtist(String artist) throws SQLException {
        String query = "SELECT S.* FROM SONGS S JOIN ARTISTS A ON (S.artist_id = A.id_artist)\n" +
                "WHERE name_artist LIKE  '%" + artist + "%'";
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
    public List<Song> searchSongByAlbum(String album) throws SQLException {
        String query = "SELECT S.* FROM SONGS S JOIN ALBUMS A ON (S.album_id = A.id_album)\n" +
                "WHERE name_album LIKE  '%" + album + "%'";
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
    public List<Song> searchSongByYear(int year) throws SQLException {
        String query = "SELECT S.* FROM SONGS S JOIN ALBUMS A ON (S.album_id = A.id_album)\n" +
                "WHERE name_album LIKE ";
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
}
