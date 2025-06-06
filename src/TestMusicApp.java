import app.controller.AppMusicController;
import app.service.ManagementAppMusicService;
import auth.controller.AuthController;
import models.dao.*;
import models.dao.interfaces.GenericDAO;
import db.SQLiteConnector;
import models.song.*;
import models.user.Admin;
import models.user.Guest;
import models.user.Member;
import profile.controller.ProfileController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TestMusicApp {

    public static void menu(){
        System.out.println("=================Menu=============\n"
                + "1) Get Items\n"
                + "2) Get one item \n"
                + "3) Create a new item\n"
                + "4) Update an item\n"
                + "5) Delete an item\n"
                + "0) Exit program\n"
                + "============================================\n"
                + "Select a Option:\n"
        );
    }

    public static void main(String[] args) throws SQLException {
        Connection c = SQLiteConnector.getConnection();
        TestMusicApp.menu();
        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt(); sc.nextLine();
        GenericDAO<Album> albumDAO = new AlbumDAOImplementation();
        GenericDAO<Artist> artistDAO = new ArtistDAOImplementation();
        GenericDAO<Genre> genreDAO = new GenreDAOImplementation();
        GenericDAO<Song> songDAO = new SongDAOImplementation();
        GenericDAO<Member> memberDAO = new MemberDAOImplementation();
        GenericDAO<Admin> adminDAO = new AdminDAOImplementation();
        GenericDAO<Guest> guestDAO = new GuestDAOImplementation();
        ManagementAppMusicService musicService = new ManagementAppMusicService();

        AuthController authController = new AuthController();
        ProfileController profileController = new ProfileController();
        AppMusicController appMusicController = new AppMusicController();



        while (opcio!=0){
            switch(opcio){
                case 1: {
                    /*albumDAO.getItems().forEach(System.out::println);*/
                    /*artistDAO.getItems().forEach(System.out::println);*/
                    /*genreDAO.getItems().forEach(System.out::println);*/
                   /* songDAO.getItems().forEach(System.out::println);*/
                    /*memberDAO.getItems().forEach(System.out::println);*/
                    /*adminDAO.getItems().forEach(System.out::println);*/
                    /*guestDAO.getItems().forEach(System.out::println);*/
                    // Testing Auth
                    // Login
                   /* System.out.println(authController.login("laura.gomez@example.com","pass1234434"));*/
                    // Register
                    /*System.out.println(authController.register("nystepro@gmail.com", "password12345"));*/




                    // Testing Profile
                    /*Member member = new Member();
                    member.setIdUser(1);*/
                    /*profileController.getHistoryProfile(member).forEach(System.out::println);*/
                    /*profileController.getProfile(member);*/
                    /*member.setNameUser("Changed a Name");
                    profileController.addInformationProfile(member);*/
                    /*profileController.*/

                    // Controller App
                    /*appMusicController.findSongByYear("1982");*/
                    /*appMusicController.findSongByTitle("Beat");
                    appMusicController.findSongByAlbum("Thriller");
                    appMusicController.findSongByGenre("Pop");
                    appMusicController.findSongByArtist("Nirvana");*/


/*                    Member member = memberDAO.readItem(12);
                    Song song = songDAO.readItem(10);
                    System.out.println(member);
                    System.out.println(song);
                    appMusicController.playSong(member,song);*/


                    break;
                }
                case 2:{
                    /*System.out.println("Put a Id valid:");
                    Integer id = sc.nextInt();*/
                    /*System.out.println(artistDAO.readItem(id));*/
                   /* System.out.println(albumDAO.readItem(idAlbum));*/
                    /*System.out.println(genreDAO.readItem(id));*/
                   /* System.out.println(songDAO.readItem(id));*/
                    /*System.out.println(memberDAO.readItem(id));*/
                    /*System.out.println(adminDAO.readItem(id));*/
                    /*System.out.println(guestDAO.readItem(id));*/
                    break;
                }
                case 3:{
                    /*System.out.println(albumDAO.createItem(new Album(0, "dummy Album", LocalDateTime.now())));*/
                    /*System.out.println(artistDAO.createItem(new Artist(0, "dummy Artist", Country.ALBANIA)));*/
                    /*System.out.println(genreDAO.createItem( new Genre(0, "dummy Genre", "dummy description")));*/
                    /*System.out.println(songDAO.createItem(new Song(0, "dummy Song", 300, 2, 2, 2)));*/
                    /*System.out.println(memberDAO.createItem(new Member(0,"dummy Member User", LocalDate.now(), "dummy@gmail.com","1234","asdasda","asdsad")));*/
                    /*System.out.println(adminDAO.createItem(new Admin(0,"dummy Admin", LocalDate.now(), "dummyAdminCreate@gmail.com","1234","2323DADAS","nickNameAdmin","ADMIN")));*/
                    /*System.out.println(guestDAO.createItem(new Guest(0,"", LocalDate.now(), null,"",null,null,"GUESTCODE4")));*/
                    break;
                }
                case 4:{
                   /* albumDAO.updateItem(new Album(1, "dummy Album", LocalDateTime.now()));*/
                    /*artistDAO.updateItem(new Artist(1, "dummy Artist updated", Country.AFGHANISTAN));*/
                    /*genreDAO.updateItem(new Genre(1, "dummy update", "dummy description"));*/
                    /*songDAO.updateItem(new Song(1, "dummy Song update", 301, 1, 1, 1));*/
                    /*memberDAO.updateItem(new Member(5,"dummy Member User edited", LocalDate.now(), "asdasdadas@gmail.com","asdsad","asdasdasdsadasdadsa","ASDASDASDASDSA"));*/
                    /*adminDAO.updateItem(new Admin(7,"dummy Admin Updated", LocalDate.now(), "12d1dasda@gmail.com","1234","121DSADAD","NewNicnameCreated","READ"));*/
                    /*guestDAO.updateItem(new Guest(10,"Guest Updated", LocalDate.now(), "Guestupdated@gmail.com","1233234","GUESDNIUpdated","GUESTnicknameUpdated","GUESTCODE2"));*/
                    break;
                }
                case 5:{
                  /*  albumDAO.deleteItem(1);*/
                   /* artistDAO.deleteItem(1);*/
                    /*genreDAO.deleteItem(1);*/
                   /* songDAO.deleteItem(1);*/
                    /*memberDAO.deleteItem(5);*/
                   /* adminDAO.deleteItem(7);*/
                   /* guestDAO.deleteItem(10);*/
                    break;
                }
                case 0:{
                    break;
                }
                default:{
                    System.out.println("Put a valid option");
                    break;
                }
            }
            TestMusicApp.menu();
            opcio = sc.nextInt();sc.nextLine();
        }
        c.close();
    }
}
