package ui;

import auth.utils.AuthDTO;
import models.user.Member;

import java.util.Scanner;

public class ViewAuth {
    private final Scanner sc = new Scanner(System.in);

    public AuthDTO login() {
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        return new AuthDTO(email, password);
    }

    public AuthDTO register() {
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        return new AuthDTO(email, password);
    }
}
