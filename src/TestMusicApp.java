import dao.*;
import db.SQLiteConnector;
import models.song.*;
import models.user.Member;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TestMusicApp {

    public static void menu(){
        System.out.println("=================Menu=============\n"
                + "1) Get Items\n"
                + "2) Get a Just Item\n"
                + "3) Create a new Item\n"
                + "4) Update a Item\n"
                + "5) Delete a Item\n"
                + "0) Close\n"
                + "============================================\n"
                + "Select a Option:\n"
        );
    }

    public static void main(String[] args) throws SQLException {
        Connection c = SQLiteConnector.getConnection();
        TestMusicApp.menu();
        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt(); sc.nextLine();
        GenericDao<Album> albumDAO = new AlbumDAOImplementation();
        GenericDao<Artist> artistDAO = new ArtistDAOImplementation();
        GenericDao<Genre> genreDAO = new GenreDAOImplementation();
        GenericDao<Song> songDAO = new SongDAOImplementation();
        GenericDao<Member> memberDAO = new MemberDAOImplementation();

        while (opcio!=0){
            switch(opcio){
                case 1: {
                    /*albumDAO.getItems().forEach(System.out::println);*/
                    /*artistDAO.getItems().forEach(System.out::println);*/
                    /*genreDAO.getItems().forEach(System.out::println);*/
                   /* songDAO.getItems().forEach(System.out::println);*/
                    memberDAO.getItems().forEach(System.out::println);
                    break;
                }
                case 2:{
                    System.out.println("Put a Id valid:");
                    Integer id = sc.nextInt();
                    /*System.out.println(artistDAO.readItem(id));*/
                   /* System.out.println(albumDAO.readItem(idAlbum));*/
                    /*System.out.println(genreDAO.readItem(id));*/
                   /* System.out.println(songDAO.readItem(id));*/
                    System.out.println(memberDAO.readItem(id));
                    break;
                }
                case 3:{
                    /*System.out.println(albumDAO.createItem(new Album(0, "dummy Album", LocalDateTime.now())));*/
                    /*System.out.println(artistDAO.createItem(new Artist(0, "dummy Artist", Country.ALBANIA)));*/
                    /*System.out.println(genreDAO.createItem( new Genre(0, "dummy Genre", "dummy description")));*/
                    /*System.out.println(songDAO.createItem(new Song(0, "dummy Song", 300, 2, 2, 2)));*/
                    System.out.println(memberDAO.createItem(new Member(0,"dummy Member User", LocalDate.now(), "dummy@gmail.com","1234","asdasda","asdsad")));
                    break;
                }
                case 4:{
                   /* albumDAO.updateItem(new Album(1, "dummy Album", LocalDateTime.now()));*/
                    /*artistDAO.updateItem(new Artist(1, "dummy Artist updated", Country.AFGHANISTAN));*/
                    /*genreDAO.updateItem(new Genre(1, "dummy update", "dummy description"));*/
                    /*songDAO.updateItem(new Song(1, "dummy Song update", 301, 1, 1, 1));*/
                    memberDAO.updateItem(new Member(5,"dummy Member User edited", LocalDate.now(), "asdasdadas@gmail.com","asdsad","asdasdasdsadasdadsa","ASDASDASDASDSA"));
                    break;
                }
                case 5:{
                  /*  albumDAO.deleteItem(1);*/
                   /* artistDAO.deleteItem(1);*/
                    /*genreDAO.deleteItem(1);*/
                   /* songDAO.deleteItem(1);*/
                    memberDAO.deleteItem(3);
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
