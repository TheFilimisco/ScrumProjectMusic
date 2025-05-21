package dao;

import db.SQLiteConnector;
import models.user.Admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AdminDAOImplementation implements GenericDao<Admin> {

    static Connection conn = SQLiteConnector.getConnection();


    @Override
    public Integer createItem(Admin admin) throws SQLException {
        return 0;
    }

    @Override
    public void deleteItem(Integer idItem) throws SQLException {

    }

    @Override
    public Admin readItem(Integer idItem) throws SQLException {
        return null;
    }

    @Override
    public void updateItem(Admin admin) throws SQLException {

    }

    @Override
    public List<Admin> getItems() throws SQLException {
        return List.of();
    }
}
