package admin.service;

import admin.dao.AdminDAOImplementation;
import models.song.Song;
import models.user.Admin;
import models.user.Member;

import java.sql.SQLException;

public class AdminService extends AdminDAOImplementation {
    public void addSong(Admin admin, Song song) throws SQLException {
        switch (admin.getAccessLevel()){
            case "ADMIN", "WRITER" -> addSong(song);
            default -> System.out.println("Invalid access level");
        }
    }

    public void updateSong(Admin admin, Song song) throws SQLException {
        switch (admin.getAccessLevel()){
            case "ADMIN", "WRITER" -> addSong(song);
            default -> System.out.println("Invalid access level");
        }
    }

    public void deleteSong(Admin admin, Song song) throws SQLException {
        switch (admin.getAccessLevel()){
            case "ADMIN" -> addSong(song);
            default -> System.out.println("Invalid access level");
        }
    }

    public void getAllSongs() throws SQLException {
        getSongs().forEach(System.out::println);
    }

    public void addMember(Admin admin, Member member) throws SQLException {
        switch (admin.getAccessLevel()){
            case "ADMIN" -> addMember(member);
            default -> System.out.println("Invalid access level");
        }
    }

    public void updateMember(Admin admin, Member member) throws SQLException {
        switch (admin.getAccessLevel()){
            case "ADMIN","WRITER" -> updateMember(member);
            default -> System.out.println("Invalid access level");
        }
    }

    public void deleteMember(Admin admin, Integer idMember) throws SQLException {
        switch (admin.getAccessLevel()){
            case "ADMIN" -> deleteMember(idMember);
            default -> System.out.println("Invalid access level");
        }
    }

    public void getAllMembers() throws SQLException {
        getMembers().forEach(System.out::println);
    }

}
