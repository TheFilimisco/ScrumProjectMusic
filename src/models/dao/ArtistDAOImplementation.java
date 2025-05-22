package models.dao;

import models.dao.interfaces.GenericDAO;
import db.SQLiteConnector;
import models.song.Artist;
import models.song.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAOImplementation implements GenericDAO<Artist> {

    static Connection conn = SQLiteConnector.getConnection();

    @Override
    public Integer createItem(Artist artist) throws SQLException {
        String query = "INSERT INTO ARTISTS(name_artist,country) VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, artist.getNameArtist());
        ps.setString(2, artist.getCountry().toString());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();

        return rs.getInt(1);
    }

    @Override
    public void deleteItem(Integer idItem) throws SQLException {
        String query = "DELETE FROM ARTISTS WHERE id_artist=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ps.executeUpdate();
        System.out.println("Artist deleted");
    }

    @Override
    public Artist readItem(Integer idItem) throws SQLException {
        String query = "SELECT * FROM ARTISTS WHERE id_artist=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ResultSet rs = ps.executeQuery();
        Artist artist = new Artist();
        boolean found = false;


        while (rs.next()) {
            found = true;
            artist.setIdArtist(rs.getInt("id_artist"));
            artist.setNameArtist(rs.getString("name_artist"));
            artist.setCountry(Country.valueOf(rs.getString("country")));

        }
        if (!found) {
            return null;
        }
        return artist;
    }

    @Override
    public void updateItem(Artist artist) throws SQLException {
        String query = "UPDATE ARTISTS SET name_artist = ?, country = ? " +
                "WHERE id_artist = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, artist.getNameArtist());
        ps.setString(2, artist.getCountry().toString());
        ps.setInt(3, artist.getIdArtist());
        ps.executeUpdate();
        System.out.println("Artist updated");
    }

    @Override
    public List<Artist> getItems() throws SQLException {
        String query = "SELECT * FROM ARTISTS";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Artist> artists = new ArrayList<Artist>();
        while (rs.next()) {
            Artist artist = new Artist();
            artist.setIdArtist(rs.getInt("id_artist"));
            artist.setNameArtist(rs.getString("name_artist"));
            artist.setCountry(Country.valueOf(rs.getString("country")));
            artists.add(artist);
        }
        return artists;
    }
}
