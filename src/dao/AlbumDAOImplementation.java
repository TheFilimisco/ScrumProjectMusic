package dao;

import db.SQLiteConnector;
import models.song.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAOImplementation implements GenericDao<Album> {

    static Connection conn = SQLiteConnector.getConnection();

    @Override
    public Integer createItem(Album album) throws SQLException {
        String query = "INSERT INTO ALBUMS(name_album,releaseDate) VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, album.getNameAlbum());
        ps.setTimestamp(2, Timestamp.valueOf(album.getReleaseDate()));
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public void deleteItem(Integer idItem) throws SQLException {
        String query = "DELETE FROM ALBUMS WHERE id_album = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ps.executeUpdate();
        System.out.println("Album deleted");
    }

    @Override
    public Album readItem(Integer idItem) throws SQLException {
        String query = "SELECT * FROM ALBUMS WHERE id_album = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ResultSet rs = ps.executeQuery();
        boolean found = false;
        Album album = new Album();

        while (rs.next()) {
            found = true;
            album.setIdAlbum(rs.getInt("id_album"));
            album.setNameAlbum(rs.getString("name_album"));
            album.setReleaseDate(rs.getTimestamp("releaseDate").toLocalDateTime());
        }

        if (!found) {
            return null;
        }
        return album;
    }

    @Override
    public void updateItem(Album album) throws SQLException {
        String query ="UPDATE ALBUMS SET name_album = ?, releaseDate = ? " +
                "WHERE id_album = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, album.getNameAlbum());
        ps.setTimestamp(2, Timestamp.valueOf(album.getReleaseDate()));
        ps.setInt(3, album.getIdAlbum());
        ps.executeUpdate();
    }

    @Override
    public List<Album> getItems() throws SQLException {
        String query = "SELECT * FROM ALBUMS";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Album> albums = new ArrayList<Album>();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("id_album"));
            album.setNameAlbum(rs.getString("name_album"));
            album.setReleaseDate(rs.getTimestamp("releaseDate").toLocalDateTime());
            albums.add(album);
        }
        if (albums.isEmpty()) {
            return null;
        }
        return albums;
    }
}
