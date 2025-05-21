package models.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class User {
    protected Integer idUser;
    protected String nameUser;
    protected LocalDate dateBirth;
    protected String email;
    protected String password;
    protected String dni;
    protected String nickName;

    protected User() {
    }

    protected User(Integer idUser, String nameUser, LocalDate dateBirth, String email, String password, String dni, String nickName) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.dateBirth = dateBirth;
        this.email = email;
        this.password = password;
        this.dni = dni;
        this.nickName = nickName;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", nameUser='" + nameUser + '\'' +
                ", dateBirth=" + dateBirth +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dni='" + dni + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}