package profile.dao;

import models.song.Song;
import models.user.Member;

import java.sql.SQLException;
import java.util.List;

public interface ProfileDAO {
    public Member validateProfile(Integer idMember) throws SQLException;
    public void updateInformationProfile(Member member) throws SQLException;
    public void deleteProfile(Integer idMember) throws SQLException;
    public List<Song> getHistoryProfile(Integer idMember) throws SQLException;
}
