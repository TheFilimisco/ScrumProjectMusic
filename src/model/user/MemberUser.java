package model.user;

import model.song.Song;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class MemberUser extends User{
//    private HashMap<Integer,Song> songsUser;


    public MemberUser(String name, LocalDate dateOfBirth, String email, String password, String identificationNumber, String nickName) {
        super(name, dateOfBirth, email, password, identificationNumber, nickName);
    }

    public MemberUser(String name, LocalDate dateOfBirth, String email, String password, String identificationNumber) {
        super(name, dateOfBirth, email, password, identificationNumber);
    }

    @Override
    public String accessPlatform() {
        return "member";
    }

}