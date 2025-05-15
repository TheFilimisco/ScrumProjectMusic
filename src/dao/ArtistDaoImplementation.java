package dao;

import model.song.Artist;

import java.sql.SQLException;
import java.util.List;

public class ArtistDaoImplementation implements GenericDao<Artist> {
    @Override
    public Artist createItem(Artist artist) throws SQLException {
        return null;
    }

    @Override
    public void deleteItem(int idItem) throws SQLException {

    }

    @Override
    public Artist readItem(int idItem) throws SQLException {
        return null;
    }

    @Override
    public void updateItem(Artist artist) throws SQLException {

    }

    @Override
    public List<Artist> getItems() throws SQLException {
        return List.of();
    }
}
