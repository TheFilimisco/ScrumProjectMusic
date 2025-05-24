package app.controller;

import app.service.ManagementAppMusicService;
import models.song.Song;
import models.user.Member;

import java.sql.SQLException;

public class AppMusicController {
    private final ManagementAppMusicService appMusicService;

    public AppMusicController() {
        this.appMusicService = new ManagementAppMusicService();
    }

    public void playSong(Song song) throws SQLException {
        appMusicService.playSong(song);
    }

    public void pauseSong(Member member, Song song) throws SQLException {
        appMusicService.pauseSong(song);
    }

    public void stopSong() throws SQLException {
        appMusicService.resumeSong();
    }

    public void nextSong() throws SQLException {
        appMusicService.nextSong();
    }

    public void previousSong() throws SQLException {
        appMusicService.previousSong();
    }

    public void findSongByTitle(String title) throws SQLException {
        appMusicService.findSongByTitle(title);
    }

    public void findSongByGenre(String genre) throws SQLException {
        appMusicService.findSongByGenre(genre);
    }

    public void findSongByAlbum(String album) throws SQLException {
        appMusicService.findSongByAlbum(album);
    }

    public void findSongByArtist(String artist) throws SQLException {
        appMusicService.findSongByArtist(artist);
    }

    public void findSongByYear(String year) throws SQLException {
        appMusicService.findSongByYear(year);
    }
}
