package dao;

import db.SQLiteConnector;
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

public class SongDAOImplementation implements GenericDao<Song> {

    static Connection conn = SQLiteConnector.getConnection();
    GenericDao<Artist> artistDAO = new ArtistDAOImplementation();
    GenericDao<Genre> genreDAO = new GenreDAOImplementation();
    GenericDao<Album> albumDAO = new AlbumDAOImplementation();

    @Override
    public Integer createItem(Song song) throws SQLException {
        String query = "INSERT INTO SONGS(title_song,duration,artist_id,genre_id,album_id) VALUES (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, song.getTitleSong());
        ps.setInt(2, song.getDuration());
        ps.setInt(3, song.getArtist().getIdArtist());
        ps.setInt(4, song.getGenre().getIdGenre());
        ps.setInt(5, song.getAlbum().getIdAlbum());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public void deleteItem(Integer idItem) throws SQLException {
        String query = "DELETE FROM SONGS WHERE id_song = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ps.executeUpdate();
        System.out.println("Song deleted");
    }

    @Override
    public Song readItem(Integer idItem) throws SQLException {
        String query = "SELECT * FROM SONGS WHERE id_song = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ResultSet rs = ps.executeQuery();
        boolean found = false;
        Song song = new Song();
        while (rs.next()) {
            found = true;
            song.setIdSong(rs.getInt("id_song"));
            song.setTitleSong(rs.getString("title_song"));
            song.setDuration(rs.getInt("duration"));
            song.setArtist(artistDAO.readItem(rs.getInt("artist_id")));
            song.setGenre(genreDAO.readItem(rs.getInt("genre_id")));
            song.setAlbum(albumDAO.readItem(rs.getInt("album_id")));
        }
        if (!found) {
            return null;
        }
        return song;
    }

    @Override
    public void updateItem(Song song) throws SQLException {
        String query = "UPDATE SONGS SET title_song = ?, duration = ?, artist_id = ?, genre_id = ?, album_id = ? " +
                "WHERE id_song = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, song.getTitleSong());
        ps.setInt(2, song.getDuration());
        ps.setInt(3, song.getArtist().getIdArtist());
        ps.setInt(4, song.getGenre().getIdGenre());
        ps.setInt(5, song.getAlbum().getIdAlbum());
        ps.setInt(6, song.getIdSong());
        ps.executeUpdate();
        System.out.println("Song updated");
    }

    @Override
    public List<Song> getItems() throws SQLException {
        String query = "SELECT * FROM SONGS";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Song> songs = new ArrayList<Song>();
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
