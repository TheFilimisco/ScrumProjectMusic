package management;

import data.DataSongs;
import model.song.*;
import model.user.AdminUser;
import model.user.GuestUser;
import model.user.User;
import model.user.memberuser.MemberUser;
import model.user.memberuser.UserHistory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MusicManager {
    private User user;
    private static int currentSongIndex;
    private static boolean isPaused;

    public MusicManager(User user) {
        this.user = user;
    }

    public MusicManager() {
    }

    public User getUser() {
        if (user instanceof MemberUser) {
            return (MemberUser) user;
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void playSong(Song song) {
        StringBuilder output = new StringBuilder("Playing: " + song.getTitle() + "\n");
        for (int i = 1; i <= song.getDuration(); i++) {
            while (isPaused) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    output.append("An error occurred during playback.");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            output.append("Playing: ").append(i).append("seconds\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                output.append("An error occurred during playback.");
                Thread.currentThread().interrupt();
                break;
            }
        }
        if (user instanceof MemberUser) {
            ((MemberUser) user).getUserHistory().counterSong(song);
            ((MemberUser) user).getUserHistory().counterAlbum(song.getAlbum());
            ((MemberUser) user).getUserHistory().counterArtist(song.getAlbum().getArtist());
            ((MemberUser) user).getUserHistory().counterGenre(song.getGenre());
        }
        output.append("Song ends.");
        System.out.println(output);

    }

    public void pauseSong(Song song, int pauseAfter) {
        try {
            System.out.println(song.getTitle() + " was paused at " + pauseAfter + " seconds...\n");
            Thread.sleep(pauseAfter * 1000);
            isPaused = true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error pausing playback.");
        }
    }


    public void resumeSong(Song song, int resumeAfter) {
        try {
            System.out.println(song.getTitle() + " restart after second " + resumeAfter + "..\n");
            Thread.sleep(resumeAfter * 1000);
            isPaused = false;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error pausing playback.");
        }
    }

    public void nextSong() {
        if (currentSongIndex == DataSongs.getInstance().getDataSongs().values().size() - 1) {
            currentSongIndex = 0;
        } else {
            currentSongIndex++;
        }
        Song nextSong = DataSongs.getInstance().getDataSongs().get(currentSongIndex);
        playSong(nextSong);
    }

    public void previousSong() {
        if (currentSongIndex == 0) {
            currentSongIndex = DataSongs.getInstance().getDataSongs().values().size() - 1;
        } else {
            currentSongIndex--;
        }
        Song previousSong = DataSongs.getInstance().getDataSongs().get(currentSongIndex);
        playSong(previousSong);
    }


    public Song searchSongByTitle(String title) {
        for (Song song : DataSongs.getInstance().getDataSongs().values()) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        throw new IllegalStateException("Song with title '" + title + "' not found.");
    }


    public ArrayList<Song> searchSongByGenre(Genre genre) {
        ArrayList<Song> songsByGenre = new ArrayList<>();

        for (Song song : DataSongs.getInstance().getDataSongs().values()) {
            if (song.getGenre().equals(genre)) {
                songsByGenre.add(song);
            }
        }
        if (songsByGenre.isEmpty()) {
            throw new IllegalStateException("No songs were found in the " + genre + " genre.");
        }
        return songsByGenre;
    }

    public ArrayList<Song> searchSongByArtist(String name) {
        ArrayList<Song> songsByArtist = new ArrayList<>();

        for (Song song : DataSongs.getInstance().getDataSongs().values()) {
            if (song.getAlbum().getArtist().getName().equalsIgnoreCase(name)) {
                songsByArtist.add(song);
            }
        }
        if (songsByArtist.isEmpty()) {
            throw new IllegalStateException("No songs were found by the artist: " + name);
        }
        return songsByArtist;
    }


    public HashSet<Album> searchAlbumsByRangeDate(LocalDate startDate, LocalDate endDate) {
        HashSet<Album> filteredAlbums = new HashSet<>();

        for (Song song : DataSongs.getInstance().getDataSongs().values()) {
            if (!song.getAlbum().getReleaseDate().isBefore(startDate) && !song.getAlbum().getReleaseDate().isAfter(endDate)) {
                filteredAlbums.add(song.getAlbum());
            }
            if (filteredAlbums.isEmpty()) {
                throw new IllegalStateException("No albums found in the specified date range.");
            }
        }

        return filteredAlbums;
    }
}






