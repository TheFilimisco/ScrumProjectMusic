package models.dao;

import models.dao.interfaces.GenericDAO;
import db.SQLiteConnector;
import models.user.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImplementation extends UserDAOImplementation implements GenericDAO<Admin> {

    static Connection conn = SQLiteConnector.getConnection();


    @Override
    public Integer createItem(Admin admin) throws SQLException {
        Integer userId = createUser(admin);
        String query2 = "INSERT INTO ADMINS(id_admin,access_level) VALUES (?,?)";
        PreparedStatement ps2 = conn.prepareStatement(query2);
        ps2.setInt(1, userId);
        ps2.setString(2, admin.getAccessLevel());
        ps2.executeUpdate();
        return userId;
    }

    @Override
    public void deleteItem(Integer idItem) throws SQLException {
        String query = "DELETE FROM ADMINS WHERE id_admin = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ps.executeUpdate();
        System.out.println("Admin deleted successfully");
    }

    @Override
    public Admin readItem(Integer idItem) throws SQLException {
        String query = "SELECT\n" +
                "    A.id_admin AS idAdmin,\n" +
                "    U.name_user AS nameUser,\n" +
                "    U.date_birth AS dateBirth,\n" +
                "    U.email AS email,\n" +
                "    U.password AS password,\n" +
                "    U.dni AS dni,\n" +
                "    U.nickname AS nickname,\n" +
                "    A.access_level AS accessLevel\n" +
                "FROM USERS U JOIN ADMINS A ON (U.id_user = A.id_admin)" +
                "WHERE id_admin = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ResultSet rs = ps.executeQuery();
        boolean found = false;
        Admin admin = new Admin();
        while (rs.next()) {
            found = true;
            admin.setIdUser(rs.getInt("idAdmin"));
            admin.setNameUser(rs.getString("nameUser"));
            admin.setDateBirth(LocalDate.parse(rs.getString("dateBirth")));
            admin.setEmail(rs.getString("email"));
            admin.setPassword(rs.getString("password"));
            admin.setDni(rs.getString("dni"));
            admin.setNickName(rs.getString("nickname"));
            admin.setAccessLevel(rs.getString("accessLevel"));
        }
        if (!found) {
            return null;
        }
        return admin;
    }

    @Override
    public void updateItem(Admin admin) throws SQLException {
        updateUser(admin);
        String query = "UPDATE ADMINS SET access_level = ? WHERE id_admin = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, admin.getAccessLevel());
        ps.setInt(2, admin.getIdUser());
        ps.executeUpdate();
    }

    @Override
    public List<Admin> getItems() throws SQLException {
        String query = "SELECT\n" +
                "    A.id_admin AS idAdmin,\n" +
                "    U.name_user AS nameUser,\n" +
                "    U.date_birth AS dateBirth,\n" +
                "    U.email AS email,\n" +
                "    U.password AS password,\n" +
                "    U.dni AS dni,\n" +
                "    U.nickname AS nickname,\n" +
                "    A.access_level AS accessLevel\n" +
                "FROM USERS U JOIN ADMINS A ON (U.id_user = A.id_admin)";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Admin> admins = new ArrayList<Admin>();
        while (rs.next()) {
            Admin admin = new Admin();
            admin.setIdUser(rs.getInt("idAdmin"));
            admin.setNameUser(rs.getString("nameUser"));
            admin.setDateBirth(LocalDate.parse(rs.getString("dateBirth")));
            admin.setEmail(rs.getString("email"));
            admin.setPassword(rs.getString("password"));
            admin.setDni(rs.getString("dni"));
            admin.setNickName(rs.getString("nickname"));
            admin.setAccessLevel(rs.getString("accessLevel"));
            admins.add(admin);
        }
        if(admins.isEmpty()){
            return null;
        }
        return admins;
    }

}
