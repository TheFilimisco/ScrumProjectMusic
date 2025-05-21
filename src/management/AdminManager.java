/*
package management;

import models.song.*;

public class AdminManager {

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

    public Genre getGenreByName(String name){
        for (Genre genre: DataSongs.getInstance().getGenres()){
            if (genre.getName().equals(name)){
                return genre;
            }
        }
        return null;
    }

}
*/
