package ui;

import auth.Authentication;
import java.util.Scanner;
import management.MusicManager;
import model.user.User;
import model.user.MemberUser;
import model.user.AdminUser;

import java.time.LocalDate;

public class UI {

    public void addNewUser(Scanner sc, Authentication auth){
        System.out.println("Enter user type (admin/member): ");
        String userType = sc.next().toLowerCase();

        System.out.print("Enter name: ");
        String name = sc.next();

        System.out.print("Enter date of birth (yyyy-mm-dd): ");
        LocalDate dateOfBirth = LocalDate.parse(sc.next());

        System.out.print("Enter email: ");
        String email = sc.next();

        System.out.print("Enter password (8 chars, 1 uppercase, 1 digit): ");
        String password = sc.next();

        System.out.print("Enter DNI (8 numbers, 1 uppercase letter): ");
        String dni = sc.next();

        System.out.println("Enter nickname: ");
        String nickname = sc.next();

//        if (nickname.isEmpty()) {
//        }

        User newUser;
        if (userType.equals("admin")) {
            newUser = new AdminUser(name, dateOfBirth, email, password, dni, nickname);
        } else {
            newUser = new MemberUser(name, dateOfBirth, email, password, dni, nickname);
        }
        try {
            auth.register(newUser);
            System.out.println("User registered");
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }
    }

//Lia - me falta añadir anonimous
    public User loginInput(Scanner sc, Authentication auth){
        System.out.print("Enter nickname: ");
        String nickname = sc.next();

        System.out.print("Enter password: ");
        String password = sc.next();

        try {
            User user = auth.login(nickname, password);
            System.out.println("Login successful. Welcome, " + user.getName() + "!");
            return user;
        } catch (IllegalStateException e) {
            System.out.println("Login failed: " + e.getMessage());
            return null;
        }
    }

    // Lia- Hago menú? Pues ya lo he hecho
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Authentication auth = new Authentication();
        UI ui = new UI();
        MusicManager manager = new MusicManager();

        boolean loop = true;
        while (loop) {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("4. Music Manager");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ui.addNewUser(sc,auth);
                    break;
                case 2:
                    ui.loginInput(sc,auth);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    loop = false;
                    break;
                case 4:
                    System.out.println("Welcome to the Music Manager. Please choose an option:");
                    while (loop) {
                        System.out.println("1. Show Profile");
                        System.out.println("2. Show Top 10 Songs");
                        System.out.println("3. Show Top 3 Genres");
                        System.out.println("4. Show Top Artist");
                        System.out.println("5. Update Nickname");
                        System.out.println("6. Update Email");
                        System.out.println("7. Update Password");
                        System.out.println("8. Exit");

                        switch(choice){
                            case 1:
                                manager.showProfile();
                        }
                    }
                    }
                    }
        }
    }
