package model.song;

import java.util.ArrayList;

public class Artist {
    private String name;
    private Country country;
    private ArrayList<Album> albums;

    public Artist(String name, Country country) {
        this.name = name;
        this.country = country;
        this.albums = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", country=" + country +
                ", albums=" + albums +
                '}';
    }
}