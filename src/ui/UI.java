package ui;

import auth.Authentication;

import java.util.*;

import data.DataSongs;
import management.MusicManager;
import management.AdminManager;
import model.song.Album;
import model.song.Artist;
import model.song.Genre;
import model.song.Song;
import model.user.GuestUser;
import model.user.User;
import model.user.AdminUser;
import model.user.memberuser.MemberUser;

import java.time.LocalDate;

public class UI {

    private void firstMenu() {
        System.out.println("""
                ========================Welcome Music Recommender System=====================
                1. Register
                2. Login Admin or Member
                3. Access App (Guest User)
                4. Leave
                =============================================================================
                """);
        System.out.print("Select your option: ");
    }


    private void secondMenu() {
        System.out.println("""
                =========================== App ===============================
                1. Access to Profile
                2. Search Songs by Title
                3. Search Songs by Genre
                4. Search Songs by Artist
                5. Search Songs by Date(YYY-mm-dd)
                6. Real-Time Song Search
                7. Back
                ================================================================
                """);
        System.out.print("Select your option: ");
    }

    private void songMenu() {
        System.out.println("""
                =========================Song Menu===============================
                1. Play song
                2. Pause song
                3. Resume song
                4. Next song
                5. Previous song
                6. Back
                =================================================================
                """);
        System.out.print("Select your option: ");
    }

    private void profileMenu() {
        System.out.println("""
                =========================Profile Menu===============================
                1. Show Top Songs
                2. Show Top Albums
                3. Show Top Artists
                4. Show Top Genres
                5. Back
                =================================================================
                """);
        System.out.print("Select your option: ");
    }


    private void adminMenu() {
        System.out.println("""
                =============================Admin Manager Menu============================
                1.Add song
                2.Update song
                3.Remove song
                4.Show All song
                5. Back
                ===========================================================================
                """);
        System.out.print("Select your option: ");
    }


    //Works
    private void addNewUser(Scanner sc, Authentication auth) {
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


    private User loginInput(Scanner sc, Authentication auth) {
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

    private User loginGuestInput() {
        return new GuestUser();
    }

    //Works
    public void mainLevel(Scanner sc, Authentication auth, MusicManager musicManager, AdminManager adminManager) {
        boolean loop = true;
        while (loop) {
            firstMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //Works!
                    addNewUser(sc, auth);
                    break;
                case 2:
                    //Works!!
                    User user = loginInput(sc, auth);
                    if (user instanceof AdminUser) {
                        adminMenu(sc, adminManager);
                    } else if (user instanceof MemberUser) {
                        secondLevel(sc, musicManager, user);
                    }
                    break;
                case 3:
                    //Works!!
                    User userGuest = loginGuestInput();
                    secondLevel(sc, musicManager, userGuest);
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


    private Song creatNewSong(Scanner sc, AdminManager adminManager) {
        sc.nextLine();
        System.out.print("Enter Title: ");
        var titleSong = sc.nextLine();
        System.out.print("Enter Albums' Name: ");
        var albumName = sc.nextLine();
        System.out.print("Enter Genre's Name: ");
        var genreName = sc.nextLine();
        System.out.print("Enter Duration: ");
        var duration = sc.nextInt();
        return new Song(titleSong, adminManager.getAlbumByName(albumName), adminManager.getGenreByName(genreName), duration);
    }

    private int enterId(Scanner sc) {
        System.out.println("Enter your Id: ");
        return sc.nextInt();
    }

    private void adminMenu(Scanner sc, AdminManager adminManager) {
        boolean loop = true;
        while (loop) {
            adminMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("============Add Song==============");
                    adminManager.addSong(creatNewSong(sc, adminManager));
                    break;
                case 2:
                    System.out.println("============Update Song==============");
                    adminManager.updateSong(enterId(sc), creatNewSong(sc, adminManager));
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
                    System.out.println("Close...");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }
    }


    private void secondLevel(Scanner sc, MusicManager musicManager, User user) {
        musicManager.setUser(user);
        boolean loop = true;
        while (loop) {
            secondMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("=================Access your Profile=============");
                    try {
                        profileLevel(sc, (MemberUser) user);
                    } catch (Exception e) {
                        System.out.println("Access denied!");
                    }
                    break;
                case 2:
                    System.out.println("=================Search Song By Title=============");
                    System.out.print("Enter Title:");
                    var inputTitle = sc.nextLine();
                    try {
                        var song = musicManager.searchSongByTitle(inputTitle);
                        songLevel(sc, musicManager, song);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("=================Search Songs By Genre=============");
                    System.out.print("Enter Genre: ");
                    var inputGenre = sc.nextLine();
                    try {
                        Genre genre = DataSongs.getInstance().getGenreByName(inputGenre);
                        ArrayList<Song> songs = musicManager.searchSongByGenre(genre);
                        if (songs.isEmpty()) {
                            System.out.println("No songs found in the genre: " + inputGenre);
                        } else {
                            System.out.println("Songs in the genre " + inputGenre + ":");
                            for (Song actualSong : songs) {
                                System.out.println("- " + actualSong.getTitle());
                            }
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("=================Search Songs By Artist=============");
                    System.out.print("Enter Artist: ");
                    var inputArtist = sc.nextLine().trim();
                    try {
                        ArrayList<Song> songsByArtist = musicManager.searchSongByArtist(inputArtist);
                        if (songsByArtist.isEmpty()) {
                            System.out.println("No songs found by the artist: " + inputArtist);
                        } else {
                            System.out.println("Songs by artist " + inputArtist + ":");
                            for (Song actualSong : songsByArtist) {
                                System.out.println("- " + actualSong.getTitle());
                            }
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("=================Search Albums By Range Date=============");
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    String startDateInput = sc.nextLine().trim();

                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    String endDateInput = sc.nextLine().trim();

                    try {
                        LocalDate startDate = LocalDate.parse(startDateInput);
                        LocalDate endDate = LocalDate.parse(endDateInput);

                        HashSet<Album> albumsInRange = musicManager.searchAlbumsByRangeDate(startDate, endDate);

                        System.out.println("Albums found in the specified date range:");
                        for (Album album : albumsInRange) {
                            System.out.println("- " + album.getName() + " (" + album.getReleaseDate() + ")");
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("=================Real Time Song Search =============");
                    musicManager.searchSongRealTime(sc);
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

    private void songLevel(Scanner sc, MusicManager musicManager, Song song) {
        boolean loop = true;
        while (loop) {
            songMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("============Play Song============");
                    musicManager.playSong(song);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("============Pause Song============");
                    System.out.print("Enter Second:");
                    var inputPauseSecond = sc.nextInt();
                    musicManager.pauseSong(song, inputPauseSecond);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("============Resume Song============");
                    System.out.print("Enter Second:");
                    var inputResumeSecond = sc.nextInt();
                    musicManager.resumeSong(song, inputResumeSecond);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("============Next Song============");
                    musicManager.nextSong();
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("============Previous Song============");
                    musicManager.previousSong();
                    break;
                case 6:
                    System.out.println("Back...");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }
    }

    private void profileLevel(Scanner sc, MemberUser user) {
        boolean loop = true;
        while (loop) {
            profileMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("=================Most Listened Songs=============");
                    user.getUserHistory().showFavoriteSongs();
                    break;
                case 2:
                    System.out.println("=================Most Listened Albums=============");
                    user.getUserHistory().showFavoriteAlbums();
                    break;
                case 3:
                    System.out.println("=================Most Listened Artists=============");
                    user.getUserHistory().showFavoriteArtists();
                    break;
                case 4:
                    System.out.println("=================Most Listened Genres=============");
                    user.getUserHistory().showFavoriteGenres();
                    break;
                case 5:
                    System.out.println("Back...");
                    loop = false;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }
    }

}
