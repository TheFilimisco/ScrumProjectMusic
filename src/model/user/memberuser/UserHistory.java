package model.user.memberuser;

import data.DataSongs;
import model.song.Album;
import model.song.Artist;
import model.song.Genre;
import model.song.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserHistory {
    private HashMap<Song, Integer> historySongs;
    private HashMap<Album, Integer> historyAlbums;
    private HashMap<Artist, Integer> historyArtists;
    private HashMap<Genre, Integer> historyGenres;

    public UserHistory() {
        historySongs = new HashMap<>();
        historyAlbums = new HashMap<>();
        historyArtists = new HashMap<>();
        historyGenres = new HashMap<>();
    }

    public HashMap<Song, Integer> getHistorySongs() {
        return historySongs;
    }

    public HashMap<Album, Integer> getHistoryAlbums() {
        return historyAlbums;
    }

    public HashMap<Artist, Integer> getHistoryArtists() {
        return historyArtists;
    }

    public HashMap<Genre, Integer> getHistoryGenres() {
        return historyGenres;
    }

    public void setHistorySongs(HashMap<Song, Integer> historySongs) {
        this.historySongs = historySongs;
    }

    public void setHistoryAlbums(HashMap<Album, Integer> historyAlbums) {
        this.historyAlbums = historyAlbums;
    }

    public void setHistoryArtists(HashMap<Artist, Integer> historyArtists) {
        this.historyArtists = historyArtists;
    }

    public void setHistoryGenres(HashMap<Genre, Integer> historyGenres) {
        this.historyGenres = historyGenres;
    }

    public void counterSong(Song song){
        historySongs.put(song, historySongs.getOrDefault(song, 0) + 1);
    }

    public void showFavoriteSongs(){
        List<Map.Entry<Song,Integer>> newListSongs =new ArrayList<>(historySongs.entrySet());
        newListSongs.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Song,Integer> entry: newListSongs){
            System.out.println(entry.getKey().getTitle() + ":" + entry.getValue());
        }
    }

    public void showFavoriteAlbums(){
        List<Map.Entry<Song,Integer>> newListSongs =new ArrayList<>(historySongs.entrySet());
        newListSongs.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Song,Integer> entry: newListSongs){
            System.out.println(entry.getKey().getTitle() + ":" + entry.getValue());
        }
    }

    public void showFavoriteArtists(){
        List<Map.Entry<Song,Integer>> newListSongs =new ArrayList<>(historySongs.entrySet());
        newListSongs.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Song,Integer> entry: newListSongs){
            System.out.println(entry.getKey().getTitle() + ":" + entry.getValue());
        }
    }

    public void showFavoriteGenres(){
        List<Map.Entry<Song,Integer>> newListSongs =new ArrayList<>(historySongs.entrySet());
        newListSongs.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Song,Integer> entry: newListSongs){
            System.out.println(entry.getKey().getTitle() + ":" + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "songCounter=" + historySongs +
                '}';
    }
}
