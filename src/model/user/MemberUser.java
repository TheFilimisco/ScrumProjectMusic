package model.user;

import management.UserHistory;
import model.song.Song;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MemberUser extends User{
        private UserHistory history;
        private HashMap<Integer,Integer> counter;

    public MemberUser(String name, LocalDate dateOfBirth, String email, String password, String identificationNumber, String nickName) {
        super(name, dateOfBirth, email, password, identificationNumber, nickName);
        this.history = new UserHistory();
    }

    public HashMap<Integer, Integer> getCounter() {
        return counter;
    }

    public void setCounter(HashMap<Integer, Integer> counter) {
        this.counter = counter;
    }

    @Override
    public String accessPlatform() {
        return "member";
    }

//    public static void main(String[] args) {
//        MemberUser memberUser = new MemberUser("Steven", , "")
//    }
}
