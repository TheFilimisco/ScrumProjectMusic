package model.user;

import management.AdminManager;

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

//    private void showAllUsers(List<User> users) {
//        System.out.println("All the users registered:");
//        for (User user : users) {
//            System.out.println(user.getNickName());
//        }
//    }

    public static void main(String[] args) {
        AdminUser adminUser1 = new AdminUser(
                "Julia Daswani",
                LocalDate.of(2003, 4, 23),
                "juliaprem23@gmail.com",
                "Abcdefgh1",
                "47598354S",
                "AdminJulia"
        );

        AdminManager adminManager = new AdminManager(adminUser1);

        System.out.println("Name: " + adminUser1.getName());
        System.out.println("Birhdate: " + adminUser1.getDateOfBirth());
        System.out.println("Email: " + adminUser1.getEmail());
        System.out.println("Nickname: " + adminUser1.getNickName());
        System.out.println("Platform access: " + adminUser1.accessPlatform());

        if (adminUser1.accessPlatform().equals("admin")) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED. Try Again.");
        }
    }
}