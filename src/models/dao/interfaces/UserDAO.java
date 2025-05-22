package models.dao.interfaces;

import models.user.User;

import java.sql.SQLException;

public interface UserDAO {
    public Integer createUser(User user) throws SQLException;
    public void updateUser(User user) throws SQLException;
    public void deleteUser(User user) throws SQLException;
}
