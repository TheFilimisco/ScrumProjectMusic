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
        String query = "SELECT * FROM USERS WHERE email = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        Member member = new Member();
        if (rs.next()) {
            member.setEmail(rs.getString("email"));
        }
        if (member.getEmail() == null) {
            return null;
        }
        return member;
    }

}
