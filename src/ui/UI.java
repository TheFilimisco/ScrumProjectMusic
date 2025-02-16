package ui;

import auth.Authentication;
import java.util.Scanner;

import management.MusicManager;
import management.AdminManager;
import model.song.Song;
import model.user.GuestUser;
import model.user.User;
import model.user.AdminUser;
import model.user.memberuser.MemberUser;

import java.time.LocalDate;

public class UI {

    private void firstMenu() {
        System.out.println("""
                1. Register
                2. Login Admin or Member
                3. Access App (Guest User)
                4. Leave
                """);
        System.out.print("Select your option: ");
    }


    private void secondMenu(){
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

    private void songMenu(){
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


    private void adminMenu(){
        System.out.println("""
                1.Add song
                2.Update song
                3.Remove song
                4.Show All song
                5. Back
                """);
        System.out.print("Select your option: ");
    }


    //Works
    private void addNewUser(Scanner sc, Authentication auth){
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
        sc.nextLine();
        System.out.print("Enter nickname: ");
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


    private User loginInput(Scanner sc, Authentication auth){
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

    //Works
    public void mainLevel(Scanner sc, Authentication auth, MusicManager musicManager, AdminManager adminManager){
        boolean loop = true;
        while (loop) {
            firstMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //Works!
                    addNewUser(sc,auth);
                    break;
                case 2:
                    //Works!!
                    User user = loginInput(sc,auth);
                    if ( user instanceof AdminUser){
                        adminMenu(sc,adminManager);
                    } else if (user instanceof MemberUser) {
                        secondLevel(sc,musicManager,user);
                    }
                    break;
                case 3:
                    //Works!!
                    User userGuest = loginGuestInput();
                    secondLevel(sc,musicManager,userGuest);
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



    private Song creatNewSong(Scanner sc, AdminManager adminManager){
        sc.nextLine();
        System.out.print("Enter Title: ");
        var titleSong = sc.nextLine();
        System.out.print("Enter Albums' Name: ");
        var albumName = sc.nextLine();
        System.out.print("Enter Genre's Name: ");
        var genreName = sc.nextLine();
        System.out.print("Enter Duration: ");
        var duration = sc.nextInt();
        return new Song(titleSong,adminManager.getAlbumByName(albumName),adminManager.getGenreByName(genreName),duration);
    }

    private int enterId(Scanner sc){
        System.out.println("Enter your Id: ");
        return sc.nextInt();
    }

    private void adminMenu(Scanner sc, AdminManager adminManager){
        boolean loop = true;
        while (loop){
            adminMenu();
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("============Add Song==============");
                    adminManager.addSong(creatNewSong(sc,adminManager));
                    break;
                case 2:
                    System.out.println("============Update Song==============");
                    adminManager.updateSong(enterId(sc),creatNewSong(sc,adminManager));
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("============Remove Song==============");
                    adminManager.removeSong(enterId(sc));
                    break;
                case 4:
                    System.out.println("============Show All Song==============");
                    adminManager.showAllSongs();
                    break;
                case 5:
                    System.out.println("Back");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }

    }

    private void secondLevel(Scanner sc, MusicManager musicManager, User user){
        boolean loop = true;
        while (loop) {
            secondMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("=================Access your Profile=============");
                    //MethodMemberProfileManager
                    break;
                case 2:
                    System.out.println("=================SearchSongByTitle=============");
                    break;
                case 3:
                    System.out.println("=================SearchSongByGenre=============");
                    break;
                case 4:
                    System.out.println("=================SearchSongByArtist=============");
                    break;
                case 5:
                    System.out.println("=================SearchSongByRangeDate=============");
                    break;
                case 6:
                    System.out.println("=================Real Time Song Search =============");
                    break;
                case 7:
                    System.out.println("Back");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Authentication auth = new Authentication();
        MusicManager manager = new MusicManager();
        AdminManager adminManager = new AdminManager();
        UI ui = new UI();
        ui.mainLevel(sc,auth,manager,adminManager);
    }

}
