package model.user;

import java.time.LocalDate;
import java.util.List;

public class AdminUser extends User{

    public AdminUser() {
    }

    public AdminUser(String name, LocalDate dateOfBirth, String email, String password, String identificationNumber, String nickName) {
        super(name, dateOfBirth, email, password, identificationNumber, nickName);
    }

    @Override
    public String accessPlatform() {
        return "admin";
    }

    private void showAllUsers(List<User> users) {
        System.out.println("All the users registered:");
        for (User user : users) {
            System.out.println(user.getNickName());
        }
    }

}
