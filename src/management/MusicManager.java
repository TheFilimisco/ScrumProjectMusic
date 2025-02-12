package management;

import model.song.Artist;
import model.song.Genre;
import model.song.Song;

import java.util.ArrayList;

public class MusicManager {
    private ArrayList<Song> songs;
    private int currentSongIndex;
    private boolean isPaused;

    public MusicManager() {
        songs = new ArrayList<>();
        isPaused = false;
    }

    //en cada manager lo vamos a hacer? no tiene sentido, quizas hacer un manager padre?
    public void addSong(Song song) {
        songs.add(song);
    }

    private void validateSong(Song song) {
        if (!songs.contains(song)) {
            throw new IllegalStateException("Song not found.");
        }
    }

    public void playSong(Song song) {
        validateSong(song);

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
        output.append("Song ends.");
        System.out.println(output.toString());
    }

    public void pauseSong(Song song, int pauseAfter) {
        validateSong(song);

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
        validateSong(song);

        try {
            System.out.println(song.getTitle() + " restart after second " + resumeAfter + "..\n");
            Thread.sleep(resumeAfter * 1000);
            isPaused = false;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error pausing playback.");
        }
    }

    public void nextSong(Song song) {
        validateSong(song);

        if (currentSongIndex == songs.size() - 1) {
            currentSongIndex = 0;
        } else {
            currentSongIndex++;
        }

        Song nextSong = songs.get(currentSongIndex);
        playSong(nextSong);
    }

    public void previousSong(Song song) {
        validateSong(song);

        if (currentSongIndex == 0) {
            currentSongIndex = songs.size() - 1;
        } else {
            currentSongIndex--;
        }

        Song previousSong = songs.get(currentSongIndex);
        playSong(previousSong);
    }

    public Song searchSongByTitle(String title) {
        for (Song song : songs) {
            if (song.getTitle().toLowerCase().equals(title)) {
                return song;
            }
        }
        throw new IllegalStateException("Song with title '" + title + "' not found.");
    }

    public ArrayList<Song> searchSongByGenre(Genre genre) {
        ArrayList<Song> songsByGenre = new ArrayList<>();

        for (Song song : songs) {
            if (song.getGenre().equals(genre)) {
                songsByGenre.add(song);
            }
        }
        if (songsByGenre.isEmpty()) {
            throw new IllegalStateException("No songs were found in the " + genre + " genre.");
        }
        return songsByGenre;
    }

    public ArrayList<Song> searchSongByArtist(Artist artist) {
        ArrayList<Song> songsByArtist = new ArrayList<>();

        for (Song song : songs) {
            if (song.getArtist().equals(artist)) {
                songsByArtist.add(song);
            }
        }
        if (songsByArtist.isEmpty()) {
            throw new IllegalStateException("No songs were found by the artist  " + artist.getName());
        }
        return songsByArtist;
    }
}
