package models.user;

import java.time.LocalDate;

public class Member extends User {
    public Member() {}

    public Member(Integer idUser, String nameUser, LocalDate dateBirth, String email, String password, String dni, String nickName) {
        super(idUser, nameUser, dateBirth, email, password, dni, nickName);
    }

    @Override
    public String toString() {
        return "Member{" +
                "idUser=" + idUser +
                ", nameUser='" + nameUser + '\'' +
                ", dateBirth=" + dateBirth +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dni='" + dni + '\'' +
                ", nickName='" + nickName + '\'' +
                "} ";
    }
}
