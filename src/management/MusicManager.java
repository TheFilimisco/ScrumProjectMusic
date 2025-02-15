package management;

import model.song.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class MusicManager {
    private ArrayList<Song> songs;
    private HashSet<Album> albums;
    private int currentSongIndex;
    private boolean isPaused;

    public MusicManager() {
        songs = new ArrayList<>();
        albums = new HashSet<>();
        isPaused = false;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void addAlbum(String name, LocalDate releaseDate) {
        Album newAlbum = new Album(name, releaseDate);
        albums.add(newAlbum);
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

    public HashSet<Album> searchAlbumsByRangeDate(LocalDate startDate, LocalDate endDate) {
        HashSet<Album> filteredAlbums = new HashSet<>();

        for (Album album : albums) {
            if (!album.getReleaseDate().isBefore(startDate) && !album.getReleaseDate().isAfter(endDate)) {
                filteredAlbums.add(album);
            }

            if (filteredAlbums.isEmpty()) {
                throw new IllegalStateException("No albums found in the specified date range.");
            }

        }
        return filteredAlbums;
    }

    public static void main(String[] args) {
        MusicManager manager = new MusicManager();

        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 2, 13);

        Album testAlbum = new Album("DeBÍ TiRAR MáS FOToS",LocalDate.of(2025, 2, 13));
        Album testAlbum2 = new Album("Cuatro",LocalDate.of(2024,5,13));

        Artist testArtist = new Artist("Bad Bunny", Country.PUERTO_RICO);
        Artist testArtist2 = new Artist("Camilo", Country.COLOMBIA);

        Genre testGenre = new Genre("Reggaeton","description","Puerto rico");
        Song testSong = new Song("DtMF",testAlbum,testArtist,testGenre,6);
        Song testSong2 = new Song("PLIS",testAlbum2,testArtist2,testGenre,8);
        Song testSong3 = new Song("No se vale",testAlbum2,testArtist2,testGenre,8);


        testAlbum.addSong(testSong);
        testAlbum2.addSong(testSong2);
        testAlbum2.addSong(testSong3);


        manager.addSong(testSong);
        manager.addSong(testSong2);
        manager.addSong(testSong3);
        manager.addAlbum(testAlbum.getName(),testAlbum.getReleaseDate());
        manager.addAlbum(testAlbum2.getName(),testAlbum2.getReleaseDate());

        //PLAY SONG
        System.out.println("PLAY SONG: \n");
        manager.playSong(testSong);

        //PAUSE SONG
        System.out.println("PAUSE SONG: \n");
        manager.pauseSong(testSong,5);

        //RESUME SONG
        System.out.println("RESUME SONG: \n");
        manager.resumeSong(testSong,5);

        //NEXT SONG
        System.out.println("PLAY NEXT SONG: \n");
        manager.nextSong(testSong3);

        //PREVIOUS SONG
        System.out.println("PLAY PREVIOUS SONG: \n");
        manager.previousSong(testSong2);

        //SEARCH SONG BY TITTLE
        System.out.println("SEARCH SONG BY TITTLE: \n");
        System.out.println(manager.searchSongByTitle("plis") );

        //SEARCH SONGS BY GENRE
        System.out.println("SEARCH SONGS BY GENRE: \n");
        System.out.println(manager.searchSongByGenre(testGenre));

        //SEARCH SONG BY ARTIST
        System.out.println("SEARCH SONG BY ARTIST \n");
        System.out.println(manager.searchSongByArtist(testArtist));

        //SEARCH ALBUMS BY RANGE DATE
        System.out.println("SEARCH ALBUMS BY RANGE DATE \n");
        System.out.println(manager.searchAlbumsByRangeDate(startDate,endDate));
    }

}



