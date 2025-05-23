package app.controller;

import app.service.ManagementAppMusicService;
import models.song.Song;
import models.user.Member;

import java.sql.SQLException;

public class AppMusicController {
    private final ManagementAppMusicService appMusicService;

    public AppMusicController() {
        appMusicService = new ManagementAppMusicService();
    }

    public void playSong(Member member, Song song) throws SQLException {
        appMusicService.playSong(member,song);
    }

    public void pauseSong(Member member, Song song) throws SQLException {
        appMusicService.pauseSong(song);
    }

    public void stopSong(Member member, Song song) throws SQLException {
        appMusicService.resumeSong(member,song);
    }

    public void nextSong(Member member) throws SQLException {
        appMusicService.nextSong(member);
    }

    public void previousSong(Member member) throws SQLException {
        appMusicService.previousSong(member);
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
