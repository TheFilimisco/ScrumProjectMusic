package management;

import model.song.Song;
import model.song.Artist;
import model.song.Genre;
import model.user.AdminUser;

import java.util.ArrayList;
import java.util.List;

public class AdminManager {
    private AdminUser adminUser;
    private ArrayList<Song> songs;
    private ArrayList<Artist> artists;
    private ArrayList<Genre> genres;

//Lia - me gusta más arraylist pero a lo mejor deberíamos poner list

    public AdminManager(AdminUser adminUser) {
        this.adminUser = adminUser;
        this.songs = new ArrayList<>();
        this.artists = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    public void addSong(Song song) {
        if (song != null) {
            songs.add(song);
            System.out.println(song.getTitle() + " by " + song.getArtist().getName() + " added");
        } else {
            System.out.println("Error");
        }
    }

    public void showAllSongs() {
        System.out.println("List of all songs:");
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    public void addArtist(Artist artist) {
        if (artist != null) {
            artists.add(artist);
            System.out.println(artist + " added");
        } else {
            System.out.println("Error");
        }
    }

    public void showAllArtists() {
        System.out.println("List of all artists:");
        for (Artist artist : artists) {
            System.out.println(artist);
        }
    }

    public void addGenre(Genre genre) {
        if (genre != null) {
            genres.add(genre);
            System.out.println(genre + " added");
        } else {
            System.out.println("Error");
        }
    }

    public void showAllGenres() {
        System.out.println("List of all genres:");
        for (Genre genre : genres) {
            System.out.println(genre);
        }
    }

    public static void main(String[] args) {

    }
}
