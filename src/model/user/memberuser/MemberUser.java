package model.user.memberuser;

import model.user.User;

import java.time.LocalDate;
import java.util.HashMap;

public class MemberUser extends User {
    private UserHistory userHistory;

    public MemberUser(String name, LocalDate dateOfBirth, String email, String password, String identificationNumber, String nickName) {
        super(name, dateOfBirth, email, password, identificationNumber, nickName);
        userHistory = new UserHistory();
    }

    public UserHistory getUserHistory() {
        return userHistory;
    }

    public void setUserHistory(UserHistory userHistory) {
        this.userHistory = userHistory;
    }

    @Override
    public String accessPlatform() {
        return "member";
    }

}