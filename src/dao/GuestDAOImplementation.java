package dao;

import models.user.Guest;

import java.sql.SQLException;
import java.util.List;

public class GuestDAOImplementation implements GenericDao<Guest> {


    @Override
    public Integer createItem(Guest guest) throws SQLException {
        return 0;
    }

    @Override
    public void deleteItem(Integer idItem) throws SQLException {

    }

    @Override
    public Guest readItem(Integer idItem) throws SQLException {
        return null;
    }

    @Override
    public void updateItem(Guest guest) throws SQLException {

    }

    @Override
    public List<Guest> getItems() throws SQLException {
        return List.of();
    }
}
