package auth.service;

import auth.dao.AuthDAOImplementation;
import models.dao.MemberDAOImplementation;
import models.dao.interfaces.GenericDAO;
import models.user.Member;

import java.sql.SQLException;

public class AuthService extends AuthDAOImplementation {

    public boolean login(String email, String password) throws SQLException {
        Member member = findByEmail(email);
        if (member == null) {
            return false;
        }
        if (!member.getPassword().equals(password)) {
            return false;
        }
        return true;
    };

    public boolean register(String email, String password) throws SQLException {
        GenericDAO<Member> memberDAO = new MemberDAOImplementation();
        Member member = findByEmail(email);
        if (member == null) {
            memberDAO.createItem(new Member(0,null,null,email,password,null,null));
            return true;
        }
        return false;
    }


}
