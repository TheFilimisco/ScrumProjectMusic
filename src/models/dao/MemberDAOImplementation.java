package models.dao;

import models.dao.interfaces.GenericDAO;
import db.SQLiteConnector;
import models.user.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImplementation extends UserDAOImplementation implements GenericDAO<Member> {
    static Connection conn = SQLiteConnector.getConnection();

    @Override
    public Integer createItem(Member member) throws SQLException {
        Integer userId = createUser(member);
        String query = "INSERT INTO MEMBERS(id_member) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userId);
        ps.executeUpdate();
        return userId;
    }

    @Override
    public void deleteItem(Integer idItem) throws SQLException {
        String query = "DELETE FROM MEMBERS WHERE id_member = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ps.executeUpdate();
        System.out.println("Member deleted successfully");
    }

    @Override
    public Member readItem(Integer idItem) throws SQLException {
        String query = "SELECT\n" +
                "    M.id_member AS idMember,\n" +
                "    U.name_user AS nameUser,\n" +
                "    U.date_birth AS dateBirth,\n" +
                "    U.email AS email,\n" +
                "    U.password AS password,\n" +
                "    U.dni AS dni,\n" +
                "    U.nickname AS nickname\n" +
                "FROM USERS U JOIN MEMBERS M ON (U.id_user = M.id_member)\n" +
                "WHERE M.id_member = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idItem);
        ResultSet rs = ps.executeQuery();
        boolean found = false;
        Member member = new Member();
        while (rs.next()) {
            found = true;
            member.setIdUser(rs.getInt("idMember"));
            member.setNameUser(rs.getString("nameUser"));
            member.setDateBirth(LocalDate.parse(rs.getString("dateBirth")));
            member.setEmail(rs.getString("email"));
            member.setPassword(rs.getString("password"));
            member.setDni(rs.getString("dni"));
            member.setNickName(rs.getString("nickname"));
        }
        if (!found) {
            return null;
        }
        return member;
    }

    @Override
    public void updateItem(Member member) throws SQLException {
        updateUser(member);
    }

    @Override
    public List<Member> getItems() throws SQLException {
        String query = "SELECT\n" +
                "    M.id_member AS idMember,\n" +
                "    U.name_user AS nameUser,\n" +
                "    U.date_birth AS dateBirth,\n" +
                "    U.email AS email,\n" +
                "    U.password AS password,\n" +
                "    U.dni AS dni,\n" +
                "    U.nickname AS nickname\n" +
                "FROM USERS U JOIN MEMBERS M ON (U.id_user = M.id_member)";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Member> members = new ArrayList<Member>();
        while (rs.next()) {
            Member member = new Member();
            member.setIdUser(rs.getInt("idMember"));
            member.setNameUser(rs.getString("nameUser"));
            member.setDateBirth(LocalDate.parse(rs.getString("dateBirth")));
            member.setEmail(rs.getString("email"));
            member.setPassword(rs.getString("password"));
            member.setDni(rs.getString("dni"));
            member.setNickName(rs.getString("nickname"));
            members.add(member);
        }
        if(members.isEmpty()){
            return null;
        }
        return members;
    }
}
