package profile.controller;

import models.song.Song;
import models.user.Member;
import profile.service.ProfileService;

import java.sql.SQLException;
import java.util.List;

public class ProfileController {
    private final ProfileService profileService;

    public ProfileController() {
        profileService = new ProfileService();
    }

    public void getProfile(Member member) throws SQLException {
        profileService.getInformationProfile(member);
    }

    public void addInformationProfile(Member member) throws SQLException {
        profileService.addInformationProfile(member);
    }

    public void changeInformationProfile(Member member) throws SQLException {
        profileService.changeInformationProfile(member);
    }

    public List<Song> getHistoryProfile(Member member) throws SQLException{
        return profileService.getHistoryProfile(member);
    }




}
