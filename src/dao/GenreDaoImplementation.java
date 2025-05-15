package dao;

import model.song.Genre;

import java.sql.SQLException;
import java.util.List;

public class GenreDaoImplementation implements GenericDao<Genre> {
    @Override
    public Genre createItem(Genre genre) throws SQLException {
        return null;
    }

    @Override
    public void deleteItem(int idItem) throws SQLException {

    }

    @Override
    public Genre readItem(int idItem) throws SQLException {
        return null;
    }

    @Override
    public void updateItem(Genre genre) throws SQLException {

    }

    @Override
    public List<Genre> getItems() throws SQLException {
        return List.of();
    }
}
