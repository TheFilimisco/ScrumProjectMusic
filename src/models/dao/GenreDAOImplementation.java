package models.dao;

import models.dao.interfaces.GenericDAO;
import db.SQLiteConnector;
import models.song.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAOImplementation implements GenericDAO<Genre> {

    static Connection conn = SQLiteConnector.getConnection();

    @Override
    public Integer createItem(Genre genre) throws SQLException {
        String query = "INSERT INTO GENRES(name_genre,description) VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, genre.getDescription());
        ps.setString(2, genre.getNameGenre());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public void deleteItem(Integer idItem) throws SQLException {
        String query = "DELETE FROM GENRES WHERE id_genre = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ps.executeUpdate();
        System.out.println("Genre deleted");
    }

    @Override
    public Genre readItem(Integer idItem) throws SQLException {
        String query = "SELECT * FROM GENRES WHERE id_genre = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);

        ResultSet rs = ps.executeQuery();
        Genre genre = new Genre();
        boolean found = false;
        while (rs.next()) {
            found = true;
            genre.setIdGenre(rs.getInt("id_genre"));
            genre.setNameGenre(rs.getString("name_genre"));
            genre.setDescription(rs.getString("description"));
        }
        if (!found) {
            return null;
        }
        return genre;
    }

    @Override
    public void updateItem(Genre genre) throws SQLException {
        String query = "UPDATE GENRES SET name_genre = ?, description = ? " +
                "WHERE id_genre = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, genre.getNameGenre());
        ps.setString(2, genre.getDescription());
        ps.setInt(3, genre.getIdGenre());
        ps.executeUpdate();
    }

    @Override
    public List<Genre> getItems() throws SQLException {
        String query = "SELECT * FROM GENRES";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Genre> genres = new ArrayList<>();
        while (rs.next()) {
            Genre genre = new Genre();
            genre.setIdGenre(rs.getInt("id_genre"));
            genre.setNameGenre(rs.getString("name_genre"));
            genre.setDescription(rs.getString("description"));
            genres.add(genre);
        }
        if (genres.isEmpty()) {
            return null;
        }
        return genres;
    }
}
