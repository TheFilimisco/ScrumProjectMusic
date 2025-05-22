package models.dao;

import models.dao.interfaces.UserDAO;
import db.SQLiteConnector;
import models.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDAOImplementation implements UserDAO {
    static Connection conn = SQLiteConnector.getConnection();

    @Override
    public Integer createUser(User user) throws SQLException {
        String query = "INSERT INTO USERS(name_user,date_birth,email,password,dni,nickname) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user.getNameUser());
        ps.setString(2, user.getDateBirth() != null ? user.getDateBirth().toString() : null );
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getDni());
        ps.setString(6, user.getNickName());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String query = "UPDATE USERS\n" +
                "SET\n" +
                "    name_user = ?,\n" +
                "    date_birth = ?,\n" +
                "    email = ?,\n" +
                "    password = ?,\n" +
                "    dni = ?,\n" +
                "    nickname = ?\n" +
                "WHERE id_user = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user.getNameUser());
        ps.setString(2, user.getDateBirth().toString());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getDni());
        ps.setString(6, user.getNickName());
        ps.setInt(7, user.getIdUser());
        ps.executeUpdate();
        System.out.println("User updated");
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        String query = "DELETE FROM USERS WHERE id_user = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, user.getIdUser());
        ps.executeUpdate();
    }
}
