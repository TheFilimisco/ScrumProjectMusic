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
//    private List<Song> songs;

//Lia - me gusta más arraylist pero a lo mejor deberíamos poner list

    public AdminManager(AdminUser adminUser) {
        this.adminUser = adminUser;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        if (song != null) {
            songs.add(song);
            System.out.println("Song added: " + song.getTitle() + " - " + song.getArtist().getName());
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
    }

    public void addGenre(Genre genre) {
    }
}
