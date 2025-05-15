package dao;

import model.song.Album;

import java.sql.SQLException;
import java.util.List;

public class AlbumDaoImplementation implements GenericDao<Album> {
    @Override
    public Album createItem(Album album) throws SQLException {
        return null;
    }

    @Override
    public void deleteItem(int idItem) throws SQLException {

    }

    @Override
    public Album readItem(int idItem) throws SQLException {
        return null;
    }

    @Override
    public void updateItem(Album album) throws SQLException {

    }

    @Override
    public List<Album> getItems() throws SQLException {
        return List.of();
    }
}
