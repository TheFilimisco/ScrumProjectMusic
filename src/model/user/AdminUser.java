package model.user;

import java.time.LocalDate;

public class AdminUser extends User{

    public AdminUser(String name, LocalDate dateOfBirth, String email, String password, String identificationNumber, String nickName) {
        super(name, dateOfBirth, email, password, identificationNumber, nickName);
    }


}
