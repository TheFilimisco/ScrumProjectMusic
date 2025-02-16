package management;

import data.DataSongs;
import model.song.*;
import model.user.AdminUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminManager {
    private AdminUser adminUser;

    public AdminManager(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public void addSong(Song song) {
        DataSongs.getInstance().addSong(song);
    }

    public void updateSong(int id, Song song) {
        DataSongs.getInstance().updateSong(id, song);
    }

    public void removeSong(int id){
        DataSongs.getInstance().removeSong(id);
    }

    public void showAllSongs() {
        DataSongs.getInstance().showAllSongs();
    }

//    public void addArtist(Artist artist) {
//        DataSongs.getInstance().addArtist(artist);
//    }
//
//    public void showAllArtists() {
//        DataSongs.getInstance().showAllArtists();
//    }
//
//    public void addGenre(Genre genre) {
//        DataSongs.getInstance().addGenre(genre);
//    }
//
//    public void showAllGenres() {
//        DataSongs.getInstance().showAllGenres();
//    }

    public static void main(String[] args) {
//        AdminUser adminUser1 = new AdminUser(
//                "Julia Daswani",
//                LocalDate.of(2003, 4, 23),
//                "juliaprem23@gmail.com",
//                "Abcdefgh1",
//                "47598354S",
//                "AdminJulia"
//        );
//        AdminManager adminManager = new AdminManager(adminUser1);
//
//        Artist badBunny = new Artist("Bad Bunny", Country.PUERTO_RICO);
//        Artist guayacanes = new Artist("Los Guayacanes", Country.COLOMBIA);
//
//        Album debiTirarMasFotos = new Album("DeBÍ TiRAR MáS FOToS", LocalDate.of(2025, 2, 13), badBunny);
//        Album cuatro = new Album("Cuatro", LocalDate.of(2024, 5, 13), guayacanes);
//
//        Genre reggaeton = new Genre("Reggaeton", "Puerto rico");
//        Genre salsa = new Genre("Salsa", "Puerto rico");
//
//        var dtmf = new Song("DtMF", debiTirarMasFotos, reggaeton, 8);
//        var noSeVale = new Song("No se vale", cuatro, reggaeton, 8);
//
//        adminManager.addArtist(badBunny);
//        adminManager.addArtist(guayacanes);
//        adminManager.addGenre(reggaeton);
//        adminManager.addGenre(salsa);
//
//        adminManager.addSong(dtmf);
//        adminManager.addSong(noSeVale);
//
//        System.out.println("\nLista de artistas:");
//        adminManager.showAllArtists();
//        System.out.println("\nLista de géneros:");
//        adminManager.showAllGenres();
//        System.out.println("\nLista de canciones:");
//        adminManager.showAllSongs();
//
//        Song updatedSong = new Song("Wueltita", debiTirarMasFotos, reggaeton, 3);
//        adminManager.updateSong(1, updatedSong);
//
//        adminManager.removeSong(2);
//
//        System.out.println("\nLista de canciones después de modificaciones:");
//        adminManager.showAllSongs();
    }
}
