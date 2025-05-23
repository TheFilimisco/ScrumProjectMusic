package auth.dao;

import db.SQLiteConnector;
import models.user.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AuthDAOImplementation implements AuthDAO {

    static Connection conn = SQLiteConnector.getConnection();

    @Override
    public Member findByEmail(String email) throws SQLException {
        String query = "SELECT " +
                "M.id_member AS idMember, " +
                "U.email AS emailDB, " +
                "U.password AS password " +
                "FROM USERS U JOIN MEMBERS M ON (U.id_user = M.id_member) " +
                "WHERE U.email = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        Member member = new Member();
        if (rs.next()) {
            member.setIdUser(rs.getInt("idMember"));
            member.setEmail(rs.getString("emailDB"));
            member.setPassword(rs.getString("password"));
        }
        if (member.getEmail() == null) {
            return null;
        }
        return member;
    }

}
