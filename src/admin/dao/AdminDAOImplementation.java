package admin.dao;

import models.dao.GenreDAOImplementation;
import models.dao.MemberDAOImplementation;
import models.dao.SongDAOImplementation;
import models.dao.interfaces.GenericDAO;
import models.song.Genre;
import models.song.Song;
import models.user.Member;

import java.sql.SQLException;
import java.util.List;

public abstract class AdminDAOImplementation implements AdminUserDAO, AdminSongDAO{
    GenericDAO<Song> songDAO = new SongDAOImplementation();
    GenericDAO<Member> memberDAO = new MemberDAOImplementation();

    @Override
    public void addSong(Song song) throws SQLException {
        Integer idSong = songDAO.createItem(song);
        System.out.println("Added song " + idSong);
    }

    @Override
    public void updateSong(Song song) throws SQLException {
        songDAO.updateItem(song);
    }

    @Override
    public void deleteSong(Integer idSong) throws SQLException {
        songDAO.deleteItem(idSong);
    }

    @Override
    public List<Song> getSongs() throws SQLException {
        return songDAO.getItems();
    }

    @Override
    public void addMember(Member member) throws SQLException {
        Integer idMember = memberDAO.createItem(member);
        System.out.println("Added member " + idMember);
    }

    @Override
    public void updateMember(Member member) throws SQLException {
        memberDAO.updateItem(member);
    }

    @Override
    public void deleteMember(Integer idMember) throws SQLException {
        memberDAO.deleteItem(idMember);
    }

    @Override
    public List<Member> getMembers() throws SQLException {
        return memberDAO.getItems();
    }
}
