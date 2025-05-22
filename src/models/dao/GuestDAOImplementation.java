package models.dao;

import models.dao.interfaces.GenericDAO;
import models.user.Guest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GuestDAOImplementation extends UserDAOImplementation implements GenericDAO<Guest> {

    @Override
    public Integer createItem(Guest guest) throws SQLException {
        Integer userId = createUser(guest);
        String query2 = "INSERT INTO GUESTS(id_guest,guest_code) VALUES (?,?)";
        PreparedStatement ps2 = conn.prepareStatement(query2);
        ps2.setInt(1, userId);
        ps2.setString(2, guest.getGuestCode());
        ps2.executeUpdate();
        return userId;
    }

    @Override
    public void deleteItem(Integer idItem) throws SQLException {
        String query = "DELETE FROM GUESTS WHERE id_guest = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ps.executeUpdate();
        System.out.println("Guest deleted successfully");
    }

    @Override
    public Guest readItem(Integer idItem) throws SQLException {
        String query = "SELECT\n" +
                "    G.id_guest AS idGuest,\n" +
                "    U.name_user AS nameUser,\n" +
                "    U.date_birth AS dateBirth,\n" +
                "    U.email AS email,\n" +
                "    U.password AS password,\n" +
                "    U.dni AS dni,\n" +
                "    U.nickname AS nickname,\n" +
                "    G.guest_code AS guestCode\n" +
                "FROM USERS U JOIN GUESTS G ON (U.id_user = G.id_guest)" +
                "WHERE id_guest = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ResultSet rs = ps.executeQuery();
        boolean found = false;
        Guest guest = new Guest();
        while (rs.next()) {
            found = true;
            guest.setIdUser(rs.getInt("idGuest"));
            guest.setNameUser(rs.getString("nameUser"));
            guest.setDateBirth(LocalDate.parse(rs.getString("dateBirth")));
            guest.setEmail(rs.getString("email"));
            guest.setPassword(rs.getString("password"));
            guest.setDni(rs.getString("dni"));
            guest.setNickName(rs.getString("nickname"));
            guest.setGuestCode(rs.getString("guestCode"));
        }
        if (!found) {
            return null;
        }
        return guest;
    }

    @Override
    public void updateItem(Guest guest) throws SQLException {
        updateUser(guest);
        String query = "UPDATE GUESTS SET guest_code = ? WHERE id_guest = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, guest.getGuestCode());
        ps.setInt(2, guest.getIdUser());
        ps.executeUpdate();
    }

    @Override
    public List<Guest> getItems() throws SQLException {
        String query = "SELECT\n" +
                "    G.id_guest AS idGuest,\n" +
                "    U.name_user AS nameUser,\n" +
                "    U.date_birth AS dateBirth,\n" +
                "    U.email AS email,\n" +
                "    U.password AS password,\n" +
                "    U.dni AS dni,\n" +
                "    U.nickname AS nickname,\n" +
                "    G.guest_code AS guestCode\n" +
                "FROM USERS U JOIN GUESTS G ON (U.id_user = G.id_guest)";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Guest> guests = new ArrayList<Guest>();
        while (rs.next()) {
            Guest guest = new Guest();
            guest.setIdUser(rs.getInt("idGuest"));
            guest.setNameUser(rs.getString("nameUser"));
            guest.setDateBirth(LocalDate.parse(rs.getString("dateBirth")));
            guest.setEmail(rs.getString("email"));
            guest.setPassword(rs.getString("password"));
            guest.setDni(rs.getString("dni"));
            guest.setNickName(rs.getString("nickname"));
            guest.setGuestCode(rs.getString("guestCode"));
            guests.add(guest);
        }
        if(guests.isEmpty()){
            return null;
        }
        return guests;
    }
}
