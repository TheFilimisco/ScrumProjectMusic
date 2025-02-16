package model.user.memberuser;

import model.song.Album;
import model.song.Artist;
import model.song.Genre;
import model.song.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserHistory {
    private final HashMap<Song, Integer> historySongs;
    private final HashMap<Album, Integer> historyAlbums;
    private final HashMap<Artist, Integer> historyArtists;
    private final HashMap<Genre, Integer> historyGenres;

    public UserHistory() {
        historySongs = new HashMap<>();
        historyAlbums = new HashMap<>();
        historyArtists = new HashMap<>();
        historyGenres = new HashMap<>();
    }

    public void counterSong(Song song){
        historySongs.put(song, historySongs.getOrDefault(song, 0) + 1);
    }

    public void counterAlbum(Album album){
        historyAlbums.put(album, historyAlbums.getOrDefault(album, 0) + 1);
    }

    public void counterArtist(Artist artist){
        historyArtists.put(artist, historyArtists.getOrDefault(artist, 0) + 1);
    }

    public void counterGenre(Genre genre){
        historyGenres.put(genre, historyGenres.getOrDefault(genre, 0) + 1);
    }

    public void showFavoriteSongs(){
        List<Map.Entry<Song,Integer>> newListSongs =new ArrayList<>(historySongs.entrySet());
        newListSongs.sort(Map.Entry.<Song,Integer>comparingByValue().reversed());
        for (Map.Entry<Song,Integer> entry: newListSongs){
            System.out.println(entry.getKey().getTitle() + ": You listened to this song " + entry.getValue() + " times.");
        }
    }

    public void showFavoriteAlbums(){
        List<Map.Entry<Album,Integer>> newListAlbums = new ArrayList<>(historyAlbums.entrySet());
        newListAlbums.sort(Map.Entry.<Album,Integer>comparingByValue().reversed());
        for (Map.Entry<Album,Integer> entry: newListAlbums){
            System.out.println(entry.getKey().getName() + ": You listened a song from this album " + entry.getValue() + " times.");
        }
    }

    public void showFavoriteArtists(){
        List<Map.Entry<Artist,Integer>> newListArtists =new ArrayList<>(historyArtists.entrySet());
        newListArtists.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Artist,Integer> entry: newListArtists.reversed()){
            System.out.println(entry.getKey().getName() + ": You listened a song from this artist " + entry.getValue() + " times.");
        }
    }

    public void showFavoriteGenres(){
        List<Map.Entry<Genre,Integer>> newListGenres =new ArrayList<>(historyGenres.entrySet());
        newListGenres.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Genre,Integer> entry: newListGenres.reversed()){
            System.out.println(entry.getKey().getName() + ":: You listened a song from this genre " + entry.getValue() + " times.");
        }
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "historySongs=" + historySongs +
                ", historyAlbums=" + historyAlbums +
                ", historyArtists=" + historyArtists +
                ", historyGenres=" + historyGenres +
                '}';
    }
}

