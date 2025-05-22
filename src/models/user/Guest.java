package models.user;

import java.time.LocalDate;

public class Guest extends User {
    private String guestCode;

    public Guest() {
    }

    public Guest(Integer idUser, String nameUser, LocalDate dateBirth, String email, String password, String dni, String nickName, String guestCode) {
        super(idUser, nameUser, dateBirth, email, password, dni, nickName);
        this.guestCode = guestCode;
    }

    public String getGuestCode() {
        return guestCode;
    }

    public void setGuestCode(String guestCode) {
        this.guestCode = guestCode;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "idUser=" + idUser +
                ", nameUser='" + nameUser + '\'' +
                ", dateBirth=" + dateBirth +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dni='" + dni + '\'' +
                ", nickName='" + nickName + '\'' +
                ", guestCode='" + guestCode + '\'' +
                "} ";
    }
}
