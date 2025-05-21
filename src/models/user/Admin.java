package models.user;

import java.time.LocalDate;

public class Admin extends User{
    private String accessLevel;

    public Admin() {
    }

    public Admin(Integer idUser, String nameUser, LocalDate dateBirth, String email, String password, String dni, String nickName, String accessLevel) {
        super(idUser, nameUser, dateBirth, email, password, dni, nickName);
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idUser=" + idUser +
                ", nameUser='" + nameUser + '\'' +
                ", dateBirth=" + dateBirth +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dni='" + dni + '\'' +
                ", nickName='" + nickName + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                "} " + super.toString();
    }
}