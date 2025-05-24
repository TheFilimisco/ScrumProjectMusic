package app.service;

import app.dao.ManagementMusicDAOImplementation;
import app.utils.SongQueueManager;
import models.dao.MemberDAOImplementation;
import models.dao.SongDAOImplementation;
import models.dao.interfaces.GenericDAO;
import models.song.Song;
import models.user.Member;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class ManagementAppMusicService extends ManagementMusicDAOImplementation {
    private static Integer elapsedTime = 0;
    private static boolean isPaused = false;
    private static boolean isPlaying = false;
    private static Thread timeThread;
    private Integer idMember;

    public ManagementAppMusicService(Integer idMember) {
        this.idMember = idMember;
    }

    public ManagementAppMusicService() {
        idMember = null;
    }

    public Integer getIdMember() {
        return idMember;
    }

    public void setIdMember(Integer idMember) {
        this.idMember = idMember;
    }

    GenericDAO<Song> songDAO = new SongDAOImplementation();
    GenericDAO<Member> memberDAO = new MemberDAOImplementation();
    private final SongQueueManager queueManager = new SongQueueManager(songDAO);

    public void playSong(Song song) throws SQLException {
        if (song == null) {
            queueManager.loadSongsOfDB();
            playCurrentSong();
            return;
        }
        queueManager.loadSingleSong(song);
        playCurrentSong();
    }


    private void playCurrentSong () throws SQLException{
        Member member = memberDAO.readItem(idMember);
        Song currentSong = queueManager.getCurrentSong();
        if (currentSong == null) {
            System.out.println("No song found");
            return;
        }
        isPlaying = true;
        elapsedTime = 0;

        // Save History
        saveSongToHistory(LocalDateTime.now(), currentSong.getIdSong(), member.getIdUser());

        System.out.println("Playing song -" + currentSong.getTitleSong());
        timeThread = new Thread(() -> {
            while (isPlaying && elapsedTime < currentSong.getDuration()) {
                if (!isPaused) {
                    try {
                        Thread.sleep(1000);
                        elapsedTime++;
                        System.out.println("Song listening: " + elapsedTime + "s");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Playing thread interrupted");
                    }
                }
            }
            if (elapsedTime >= currentSong.getDuration()) {
                System.out.println("Song finished");
                try {
                    nextSong();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getCause());
                }
            }
        });
        timeThread.start();
    }

    public void nextSong () throws SQLException{
        stopCurrentThread();
        queueManager.nextSong();
        playCurrentSong();
    }

    public void previousSong () throws SQLException{
        stopCurrentThread();
        queueManager.previousSong();
        playCurrentSong();
    }

    public void pauseSong (Song song) {
        isPaused = true;
        System.out.println(song.getTitleSong() + " was paused at " + elapsedTime + " seconds...\n");
    }

    public void resumeSong () throws SQLException {
        if (isPaused && !isPlaying) {
            isPaused = false;
            playCurrentSong();
        }
    }

    private void stopCurrentThread() {
        isPlaying = false;
        isPaused = false;
        if (timeThread != null && timeThread.isAlive()) {
            timeThread.interrupt();
        }
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
