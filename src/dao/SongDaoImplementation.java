package dao;

import model.song.Song;

import java.sql.SQLException;
import java.util.List;

public class SongDaoImplementation implements GenericDao<Song> {
    @Override
    public Song createItem(Song song) throws SQLException {
        return null;
    }

    @Override
    public void deleteItem(int idItem) throws SQLException {

    }

    @Override
    public Song readItem(int idItem) throws SQLException {
        return null;
    }

    @Override
    public void updateItem(Song song) throws SQLException {

    }

    @Override
    public List<Song> getItems() throws SQLException {
        return List.of();
    }
}
