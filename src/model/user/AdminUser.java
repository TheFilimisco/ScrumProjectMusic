package model.user;

import management.AdminManager;

import java.time.LocalDate;
import java.util.List;

public class AdminUser extends User{
    
    public AdminUser(String name, LocalDate dateOfBirth, String email, String password, String identificationNumber, String nickName) {
        super(name, dateOfBirth, email, password, identificationNumber, nickName);
    }

    @Override
    public String accessPlatform() {
        return "admin";
    }

}