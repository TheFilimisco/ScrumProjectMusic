package ui;

import auth.Authentication;
import java.util.Scanner;

import management.MusicManager;
import model.user.GuestUser;
import model.user.User;
import model.user.MemberUser;
import model.user.AdminUser;

import java.time.LocalDate;

public class UI {

    public void firstMenu() {
        System.out.println("""
                1. Register
                2. Login Member
                3. Access App (Guest User)
                4. Leave
                """);
        System.out.print("Select your option: ");
    }
    public void secondMenu(){
        System.out.println("""
                1. Access to Profile
                2. Search Songs by Title
                3. Search Songs by Genre
                4. Search Songs by Artist
                5. Search Songs by Date(YYY-mm-dd)
                6. Real-Time Song Search
                7. Back
                """);
        System.out.print("Select your option: ");
    }

    public void songMenu(){
        System.out.println("""
                1.Play song
                2.Pause song
                3.Resume song
                3.Next song
                4.Previous song
                5. Back
                """);
        System.out.print("Select your option: ");
    }

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
        String nickname = sc.nextLine();
        User newUser;
        if (userType.equals("admin")) {
            newUser = new AdminUser(name, dateOfBirth, email, password, dni, nickname);
        } else {
            newUser = new MemberUser(name, dateOfBirth, email, password, dni, nickname);
        }
        try {
            auth.register(newUser);
            System.out.println("User registered with your new nickname:" + newUser.getNickName());
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }
    }


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

    private User loginGuestInput(){
        return new GuestUser();
    }

    public void mainLevel(Scanner sc, Authentication auth){
        boolean loop = true;
        while (loop) {
            firstMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addNewUser(sc,auth);
                    break;
                case 2:
                    loginInput(sc,auth);
                    break;
                case 3:
                    loginGuestInput();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }
    }


    public void secondLevel(Scanner sc, MusicManager musicManager, User user){
        boolean loop = true;
        while (loop) {
            secondMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Acceding...");
                    break;
                case 2:
                    System.out.println("===========Search Song By Title=============");
                    System.out.println("Put your title: ");
                    var putTitleSong = sc.nextLine();
                    musicManager.searchSongByTitle(putTitleSong);
                    //Here would be Menu song
                    break;
                case 3:
                    System.out.println("Close...");
                    break;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }

    }



}
