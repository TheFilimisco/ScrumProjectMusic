package profile.service;

import models.dao.MemberDAOImplementation;
import models.dao.SongDAOImplementation;
import models.dao.interfaces.GenericDAO;
import models.song.Song;
import models.user.Member;
import profile.dao.ProfileDAOImplementation;

import java.sql.SQLException;
import java.util.List;

public class ProfileService extends ProfileDAOImplementation {

    GenericDAO<Member> memberDAO = new MemberDAOImplementation();

    public void addInformationProfile(Member member) throws SQLException {
        updateInformationProfile(member);
        System.out.println("Profile completed");
    }

    public void changeInformationProfile(Member member) throws SQLException {
        updateInformationProfile(member);
        System.out.println("Profile Updated");
    }

    public List<Song> getHistoryProfile(Member member) throws SQLException {
        return getHistoryProfile(member.getIdUser());
    }

    public void getInformationProfile(Member member) throws SQLException {
        System.out.println(memberDAO.readItem(member.getIdUser()));
    }
}
