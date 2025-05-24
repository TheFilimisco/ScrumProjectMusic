package ui;

import models.user.Member;

import java.time.LocalDate;
import java.util.Scanner;

public class ProfileView {
    private Scanner sc = new Scanner(System.in);

    public Member changeInformation(Member member) {
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Birth Date(yyyy-mm-dd): ");
        String date = sc.nextLine();
        System.out.println("Enter Email: ");
        String email = sc.nextLine();
        System.out.println("Enter Password: ");
        String password = sc.nextLine();
        System.out.println("Enter DNI: ");
        String dni = sc.nextLine();
        System.out.println("Enter nickname: ");
        String nickname = sc.nextLine();
        member.setNameUser(name);
        member.setDateBirth(LocalDate.parse(date));
        member.setEmail(email);
        member.setPassword(password);
        member.setDni(dni);
        member.setNickName(nickname);
        return member;
    }


}
