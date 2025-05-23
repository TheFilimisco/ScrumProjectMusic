package admin.controller;

import admin.service.AdminService;
import models.song.Song;
import models.user.Admin;
import models.user.Member;


import java.sql.SQLException;

public class AdminController {
    private final AdminService adminService;

    public AdminController() {
        adminService = new AdminService();
    }

    public void addMember(Admin admin, Member member) throws SQLException {
        adminService.addMember(admin, member);
    }

    public void updateMember(Admin admin, Member member) throws SQLException {
        adminService.updateMember(admin, member);
    }

    public void deleteMember(Admin admin, Integer idMember) throws SQLException {
        adminService.deleteMember(admin, idMember);
    }

    public void getMembers() throws SQLException {
        adminService.getAllMembers();
    }

    public void addSong(Admin admin, Song song) throws SQLException {
        adminService.addSong(admin, song);
    }

    public void updateSong(Admin admin, Song song) throws SQLException {
        adminService.updateSong(admin, song);
    }

    public void deleteSong(Admin admin, Integer idSong) throws SQLException {
        adminService.deleteMember(admin, idSong);
    }

    public void getSongs() throws SQLException {
        adminService.getAllSongs();
    }

}
