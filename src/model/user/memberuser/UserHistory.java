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

    public UserHistory() {
        historySongs = new HashMap<>();
    }

    public HashMap<Song, Integer> getHistorySongs() {
        return historySongs;
    }

    public void setHistorySongs(HashMap<Song, Integer> historySongs) {
        this.historySongs = historySongs;
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

    @Override
    public String toString() {
        return "UserHistory{" +
                "songCounter=" + historySongs +
                '}';
    }


}
