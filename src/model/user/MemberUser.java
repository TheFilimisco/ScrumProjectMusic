package model.user;

import java.time.LocalDate;

public class MemberUser extends User{
    public MemberUser(String name, LocalDate dateOfBirth, String email, String password, String identificationNumber, String nickName) {
        super(name, dateOfBirth, email, password, identificationNumber, nickName);
    }
}
