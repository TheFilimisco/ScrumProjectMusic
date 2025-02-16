package data;

import model.song.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DataSongs {
    private static DataSongs instance;
    private HashMap<Integer,Song> dataSongs;
    private HashSet<Artist> artists;
    private HashSet<Album> albums;
    private HashSet<Genre> genres;

    public DataSongs() {
        genres = new HashSet<>();
        Genre rock = new Genre("Rock","Originated in the United States during the late 1940s and early 1950s");
        Genre reggaeton = new Genre("Reggaeton","Reggaeton is a modern style of popular music that originated in Panama during the late 1980s");
        Genre pop = new Genre("Pop", "Pop music is a genre of popular music that originated in its modern form during the mid-1950s in the United States and the United Kingdom.");
        genres.add(rock);
        genres.add(reggaeton);
        genres.add(pop);


        artists = new HashSet<>();
        Artist twentyOnePilots = new Artist("Twenty One Pilots", Country.UNITED_STATES);
        Artist badBunny = new Artist("Bad Bunny", Country.PUERTO_RICO);
        Artist tvGirl = new Artist("Tv Girl", Country.UNITED_STATES);
        artists.add(twentyOnePilots);
        artists.add(badBunny);
        artists.add(tvGirl);

        albums = new HashSet<>();
        Album blurryface = new Album("Blurryface", LocalDate.of(2015, 5, 17), twentyOnePilots);
        Album debiTirarMasFotos = new Album("DeBÍ TiRAR MáS FOToS", LocalDate.of(2025, 1, 5), badBunny);
        Album unVeranoSinTi = new Album("Un Verano Sin Ti", LocalDate.of(2022, 5, 6), badBunny);
        Album whoReallyCares = new Album("Who Really Cares", LocalDate.of(2016, 2, 26), tvGirl);

        albums.add(blurryface);
        albums.add(debiTirarMasFotos);
        albums.add(unVeranoSinTi);
        albums.add(whoReallyCares);

        Song stressedout = new Song("stressed out",blurryface,rock,3);
        Song forYou = new Song("For You", whoReallyCares, rock, 4);
        Song ride = new Song("Ride",blurryface,pop,3);
        Song neverita = new Song("Neverita", unVeranoSinTi, pop, 3);
        Song velda = new Song("Velda",debiTirarMasFotos,reggaeton,3);
        Song eoo = new Song("EoO", debiTirarMasFotos, reggaeton, 4);
        Song efecto = new Song("Efecto", unVeranoSinTi, reggaeton, 3);


        //Song to Album
        unVeranoSinTi.addSongToAlbum(neverita);
        unVeranoSinTi.addSongToAlbum(efecto);
        debiTirarMasFotos.addSongToAlbum(velda);
        debiTirarMasFotos.addSongToAlbum(eoo);
        whoReallyCares.addSongToAlbum(forYou);
        blurryface.addSongToAlbum(stressedout);
        blurryface.addSongToAlbum(ride);

        //Album to Artist
        twentyOnePilots.addNewAlbum(blurryface);
        badBunny.addNewAlbum(unVeranoSinTi);
        badBunny.addNewAlbum(debiTirarMasFotos);
        tvGirl.addNewAlbum(whoReallyCares);

        //Agg Genre
        rock.addNewSong(stressedout);
        rock.addNewSong(forYou);
        reggaeton.addNewSong(velda);
        reggaeton.addNewSong(eoo);
        reggaeton.addNewSong(efecto);
        pop.addNewSong(ride);
        pop.addNewSong(neverita);


        dataSongs = new HashMap<>();
        dataSongs.put(stressedout.getId(),stressedout);
        dataSongs.put(ride.getId(),ride);
        dataSongs.put(velda.getId(),velda);
        dataSongs.put(eoo.getId(),eoo);
        dataSongs.put(efecto.getId(),efecto);
        dataSongs.put(neverita.getId(),neverita);
        dataSongs.put(forYou.getId(),forYou);

    }

    public static DataSongs getInstance() {
        if (instance == null) {
            instance = new DataSongs();
        }
        return instance;
    }

    public HashMap<Integer, Song> getDataSongs() {
        return dataSongs;
    }

    public HashSet<Artist> getArtists() {
        return artists;
    }

    public HashSet<Album> getAlbums() {
        return albums;
    }

    public HashSet<Genre> getGenres() {
        return genres;
    }

    public void addSong(Song song) {
        dataSongs.put(song.getId(), song);
    }

    public void updateSong(int id, Song song){
        var updateSong =  dataSongs.get(id);
        updateSong.setTitle(song.getTitle());
        updateSong.setAlbum(song.getAlbum());
        updateSong.setGenre(song.getGenre());
        updateSong.setDuration(song.getDuration());
    }

    public void removeSong(int id) {
        dataSongs.remove(id);
    }

    public void showAllSongs(){
        for (Song song: dataSongs.values()){
            System.out.println(song);
        }
    }
}
