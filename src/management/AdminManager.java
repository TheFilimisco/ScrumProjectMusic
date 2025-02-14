package management;

import data.DataSongs;
import model.song.Song;
import model.song.Artist;
import model.song.Genre;
import model.user.AdminUser;

import java.util.ArrayList;
import java.util.List;

public class AdminManager {
    private AdminUser adminUser;

    public AdminManager(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public void addSong(Song song) {
        DataSongs.getInstance().addSong(song);
    }

    public void removeSong(int id){
        DataSongs.getInstance().removeSong(id);
    }

    public void showAllSongs() {
        DataSongs.getInstance().showAllSongs();
    }

//
//    public void addArtist(Artist artist) {
//        if (artist != null) {
//            artists.add(artist);
//            System.out.println(artist + " added");
//        } else {
//            System.out.println("Error");
//        }
//    }
//
//    public void showAllArtists() {
//        System.out.println("List of all artists:");
//        for (Artist artist : artists) {
//            System.out.println(artist);
//        }
//    }
//
//    public void addGenre(Genre genre) {
//        if (genre != null) {
//            genres.add(genre);
//            System.out.println(genre + " added");
//        } else {
//            System.out.println("Error");
//        }
//    }
//
//    public void showAllGenres() {
//        System.out.println("List of all genres:");
//        for (Genre genre : genres) {
//            System.out.println(genre);
//        }
//    }

}
