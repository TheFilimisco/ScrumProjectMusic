package admin.dao;

import models.user.Member;

import java.sql.SQLException;
import java.util.List;

public interface AdminUserDAO {
    public void addMember(Member member) throws SQLException;
    public void updateMember(Member member) throws SQLException;
    public void deleteMember(Integer idMember) throws SQLException;
    public List<Member> getMembers() throws SQLException;
}
