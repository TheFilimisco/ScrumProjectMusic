package model.user;

import model.song.Song;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class MemberUser extends User{
    private HashMap<Integer,Integer> songsUser;

    public MemberUser(String name, LocalDate dateOfBirth, String email, String password, String identificationNumber, String nickName) {
        super(name, dateOfBirth, email, password, identificationNumber, nickName);
        songsUser = new HashMap<Integer,Integer>();
    }

    public MemberUser() {
        songsUser = new HashMap<Integer,Integer>();
    }

    @Override
    public String accessPlatform() {
        return "member";
    }

}
