package app.service;

import app.dao.ManagementMusicDAOImplementation;
import models.dao.SongDAOImplementation;
import models.dao.interfaces.GenericDAO;
import models.song.Song;
import models.user.Member;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class ManagementAppMusicService extends ManagementMusicDAOImplementation {
    private static Integer pointerMusic;
    private static Integer elapsedTime;
    private static boolean isPaused;
    private static boolean isPlaying;
    private static Thread timeThread;

    GenericDAO<Song> songDAO = new SongDAOImplementation();


    public void playSong (Member member, Song song) throws SQLException{
        isPaused = false;
        isPlaying = true;
        pointerMusic = song.getIdSong();

        // Save History
        saveSongToHistory(LocalDateTime.now(), song.getIdSong(), member.getIdUser());

        System.out.println("Playing song -" + song.getTitleSong());
        timeThread = new Thread(() -> {
            while (isPlaying && elapsedTime < song.getDuration()) {
                if (isPaused) {
                    try {
                        Thread.sleep(1000);
                        elapsedTime++;
                        System.out.println("Current time: " + elapsedTime + "s");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Playing thread interrupted");
                    }
                }
            }
            if (elapsedTime >= song.getDuration()) {
                System.out.println("Song finished");
                isPlaying = false;
            }
        });
        timeThread.start();
    }

    public void pauseSong (Song song) {
        isPaused = true;
        System.out.println(song.getTitleSong() + " was paused at " + elapsedTime + " seconds...\n");
    }

    public void resumeSong (Member member, Song song) throws SQLException {
        if (isPaused && !isPlaying) {
            isPaused = false;
            isPlaying = true;
            System.out.println("Resuming: " + song.getTitleSong());

            playSong(member,song); // Back to thread where it stayed
        }
    }

    public void nextSong (Member member) throws SQLException{
        isPlaying = false;
        isPaused = false;
        elapsedTime = 0;

        if (timeThread != null && timeThread.isAlive()) {
            timeThread.interrupt();
        }

        pointerMusic++;
        Song nextSong = songDAO.readItem(pointerMusic);
        playSong(member,nextSong);

    }

    public void previousSong (Member member) throws SQLException{
        isPlaying = false;
        isPaused = false;
        elapsedTime = 0;

        if (timeThread != null && timeThread.isAlive()) {
            timeThread.interrupt();
        }

        pointerMusic--;
        Song previousSong = songDAO.readItem(pointerMusic);
        playSong(member,previousSong);

    }


    public void findSongByTitle (String title) throws SQLException{
        List<Song> songs = searchSongByTitle(title);
        if (songs == null || songs.isEmpty()) {
            System.out.println("Not found Songs with title " + title);
            return;
        }
        songs.forEach(System.out::println);
    }

    public void findSongByGenre (String genre) throws SQLException{
        List<Song> songs = searchSongByGenre(genre);
        if (songs == null || songs.isEmpty()) {
            System.out.println("Not found Songs with genre " + genre);
            return;
        }
        songs.forEach(System.out::println);
    }

    public void findSongByAlbum (String album) throws SQLException{
        List<Song> songs = searchSongByAlbum(album);
        if (songs == null || songs.isEmpty()) {
            System.out.println("Not found Songs with album " + album);
            return;
        }
        songs.forEach(System.out::println);
    }

    public void findSongByArtist (String artist) throws SQLException{
        List<Song> songs = searchSongByArtist(artist);
        if (songs == null || songs.isEmpty()) {
            System.out.println("Not found Songs with Artist " + artist);
            return;
        }
        songs.forEach(System.out::println);
    }

    public void findSongByYear (String year) throws SQLException{
        List<Song> songs = searchSongByYear(year);
        if (songs == null || songs.isEmpty()) {
            System.out.println("Not found Songs with Year " + year);
            return;
        }
        songs.forEach(System.out::println);
    }

}
