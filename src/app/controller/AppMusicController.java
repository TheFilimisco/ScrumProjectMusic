package app.controller;

import app.service.ManagementAppMusicService;
import models.song.Song;
import models.user.Member;

import java.sql.SQLException;
import java.util.List;

public class AppMusicController {
    private final ManagementAppMusicService appMusicService;

    public AppMusicController() {
        this.appMusicService = new ManagementAppMusicService();
    }


    public void playSong(Song song, Integer idMember) throws SQLException {
        appMusicService.setIdMember(idMember);
        appMusicService.playSong(song);
    }

    public void pauseSong(Song song) throws SQLException {
        appMusicService.pauseSong(song);
    }

    public void resumeSong() throws SQLException {
        appMusicService.resumeSong();
    }

    public void nextSong() throws SQLException {
        appMusicService.nextSong();
    }

    public void previousSong() throws SQLException {
        appMusicService.previousSong();
    }

    public List<Song> findSongByTitle(String title) throws SQLException {
        return appMusicService.findSongByTitle(title);
    }

    public List<Song> findSongByGenre(String genre) throws SQLException {
        return appMusicService.findSongByGenre(genre);
    }

    public List<Song> findSongByAlbum(String album) throws SQLException {
        return appMusicService.findSongByAlbum(album);
    }

    public List<Song> findSongByArtist(String artist) throws SQLException {
        return appMusicService.findSongByArtist(artist);
    }

    public List<Song> findSongByYear(String year) throws SQLException {
        return appMusicService.findSongByYear(year);
    }
}
