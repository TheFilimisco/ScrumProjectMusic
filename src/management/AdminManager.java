package management;

import data.DataSongs;
import model.song.*;
import model.user.AdminUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminManager {
    private AdminUser adminUser;

    public AdminManager(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public AdminManager(){

    }

    public void addSong(Song song) {
        DataSongs.getInstance().addSong(song);
    }

    public void updateSong(int id, Song song) {
        DataSongs.getInstance().updateSong(id, song);
    }

    public void removeSong(int id){
        DataSongs.getInstance().removeSong(id);
    }

    public void showAllSongs() {
        DataSongs.getInstance().showAllSongs();
    }

    public Album getAlbumByName(String name){
        for (Album album : DataSongs.getInstance().getAlbums()){
            if (album.getName().equals(name)){
                return album;
            }
        }
        return null;
    }

    public Artist getArtistByName(String name){
        for (Artist artist: DataSongs.getInstance().getArtists()){
            if (artist.getName().equals(name)){
                return artist;
            }
        }
        return null;
    }

    public Genre getGenreByName(String name){
        for (Genre genre: DataSongs.getInstance().getGenres()){
            if (genre.getName().equals(name)){
                return genre;
            }
        }
        return null;
    }
    
}
