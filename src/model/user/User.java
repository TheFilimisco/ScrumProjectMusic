package model.user;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    protected Integer id;
    protected String name;
    protected LocalDate dateOfBirth;
    protected String email;
    protected String password;
    protected String identificationNumber;
    protected String nickName;
    protected static Integer counterUser = 1;


    public User(String name, LocalDate dateOfBirth, String email, String password, String identificationNumber, String nickName) {
        id = counterUser++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.identificationNumber = identificationNumber;
        this.nickName = nickName;
    }

    public User() {
        id = 0;
        name = "";
        dateOfBirth = LocalDate.now();
        email = "";
        password = "";
        identificationNumber = "";
        nickName = "";
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String accessPlatform() {
        return "User";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(identificationNumber, user.identificationNumber) && Objects.equals(nickName, user.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identificationNumber, nickName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}