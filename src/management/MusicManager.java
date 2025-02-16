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

    public MusicManager(){

    }


    public void playSong(Song song) {
        addCounter(song);

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
            if (song.getTitle().toLowerCase().equals(title)) {
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

    public ArrayList<Song> searchSongByArtist(Artist artist) {
        ArrayList<Song> songsByArtist = new ArrayList<>();

        for (Song song : DataSongs.getInstance().getDataSongs().values()) {
            if (song.getAlbum().getArtist().equals(artist)) {
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

        for (Song song:DataSongs.getInstance().getDataSongs().values()){
                if (!song.getAlbum().getReleaseDate().isBefore(startDate) && !song.getAlbum().getReleaseDate().isAfter(endDate)) {
                    filteredAlbums.add(song.getAlbum());
                }
                if (filteredAlbums.isEmpty()) {
                    throw new IllegalStateException("No albums found in the specified date range.");
                }
        }

        return filteredAlbums;
    }

    public void addCounter(Song song) {

        int songId = song.getId();
        songCounter.put(songId, songCounter.getOrDefault(songId, 0) + 1);

        Album album = song.getAlbum();
        if (album != null) {
            albumCounter.put(album, albumCounter.getOrDefault(album, 0) + 1);
        }

        Artist artist = album != null ? album.getArtist() : null;
        if (artist != null) {
            artistCounter.put(artist, artistCounter.getOrDefault(artist, 0) + 1);
        }

        Genre genre = song.getGenre();
        if (genre != null) {
            genreCounter.put(genre, genreCounter.getOrDefault(genre, 0) + 1);
        }
    }
/*    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MusicManager manager = new MusicManager(new GuestUser());

//        AdminManager adminManager = new AdminManager(new AdminUser());

//        Album testAlbum = new Album("DeBÍ TiRAR MáS FOToS",LocalDate.of(2025, 2, 13));
//        Album testAlbum2 = new Album("Cuatro",LocalDate.of(2024,5,13));
//        Album testAlbum3 = new Album("Solo_Salsa",LocalDate.of(2024,5,13));
//
//        Genre testGenre = new Genre("Reggaeton","description","Puerto rico");
//        Genre salsa = new Genre("Salsa","description","Puerto rico");
//
        Artist badBunny = new Artist("Bad Bunny",Country.PUERTO_RICO);
//        Artist guayacanes = new Artist("Los Guayacanes", Country.COLOMBIA);

//        var dtmf = new Song("DtMF",testAlbum,testGenre,badBunny,8);
//        var plis = new Song("PLIS",testAlbum,testGenre,badBunny,8);
//        var noSeVale = new Song("No se vale",testAlbum2,testGenre,guayacanes,8);
//        var oiga = new Song("Oiga,mire, vea", testAlbum3,salsa,guayacanes, 10);

//        adminManager.addSong(dtmf);
//        adminManager.addSong(plis);
//        adminManager.addSong(noSeVale);
//        adminManager.addSong(oiga);

        LocalDate startDate = LocalDate.of(2025, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 2, 14);

        var running = true;

        while (running){
            var option = input.nextInt();
            switch (option){
                case 1:
                    input.nextLine();
                    System.out.println("Put a title: ");
                    var inputTitle = input.nextLine();
                    manager.playSong(manager.searchSongByTitle(inputTitle));
                    manager.nextSong();
                    manager.previousSong();
                    break;
                case 2:
                    System.out.println(manager.searchSongByArtist(badBunny));
                    break;
                case 3:
                    running = false;
                    break;
            }
}*/

//        testAlbum.addSong(testSong);
//        testAlbum2.addSong(testSong2);
//        testAlbum2.addSong(testSong3);
//
//
//        manager.addSong(testSong);
//        manager.addSong(testSong2);
//        manager.addSong(testSong3);
//        manager.addAlbum(testAlbum.getName(),testAlbum.getReleaseDate());
//        manager.addAlbum(testAlbum2.getName(),testAlbum2.getReleaseDate());
//
//        //PLAY SONG
//        System.out.println("PLAY SONG: \n");
//        manager.playSong(testSong);
//
//        //PAUSE SONG
//        System.out.println("PAUSE SONG: \n");
//        manager.pauseSong(testSong,5);
//
//        //RESUME SONG
//        System.out.println("RESUME SONG: \n");
//        manager.resumeSong(testSong,5);
//
//        //NEXT SONG
//        System.out.println("PLAY NEXT SONG: \n");
//        manager.nextSong(testSong3);
//
//        //PREVIOUS SONG
//        System.out.println("PLAY PREVIOUS SONG: \n");
//        manager.previousSong(testSong2);
//
//        //SEARCH SONG BY TITTLE
//        System.out.println("SEARCH SONG BY TITTLE: \n");
//        System.out.println(manager.searchSongByTitle("plis") );
//
//        //SEARCH SONGS BY GENRE
//        System.out.println("SEARCH SONGS BY GENRE: \n");
//        System.out.println(manager.searchSongByGenre(testGenre));
//
//        //SEARCH SONG BY ARTIST
//        System.out.println("SEARCH SONG BY ARTIST \n");
//        System.out.println(manager.searchSongByArtist(testArtist));
//
//        //SEARCH ALBUMS BY RANGE DATE
//        System.out.println("SEARCH ALBUMS BY RANGE DATE \n");
//        System.out.println(manager.searchAlbumsByRangeDate(startDate,endDate));
}






