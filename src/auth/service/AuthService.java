package auth.service;

import auth.dao.AuthDAOImplementation;
import auth.utils.AuthDTO;
import models.dao.MemberDAOImplementation;
import models.dao.interfaces.GenericDAO;
import models.user.Member;

import java.sql.SQLException;

public class AuthService extends AuthDAOImplementation {
    private Integer loggedUserId;

    public boolean login(AuthDTO authDTO) throws SQLException {
        Member member = findByEmail(authDTO.getEmail());
        if (member == null) {
            return false;
        }
        if (!member.getPassword().equals(authDTO.getPassword())) {
            return false;
        }
        loggedUserId = member.getIdUser();
        return true;
    }

    public boolean register(AuthDTO authDTO) throws SQLException {
        GenericDAO<Member> memberDAO = new MemberDAOImplementation();
        Member member = findByEmail(authDTO.getEmail());
        if (member == null) {
            memberDAO.createItem(new Member(0,null,null,authDTO.getEmail(), authDTO.getPassword(), null,null));
            return true;
        }
        return false;
    }

    public Integer getLoggedUserId() {
        return loggedUserId;
    }
}
