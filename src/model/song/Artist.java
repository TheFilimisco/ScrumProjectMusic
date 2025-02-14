package model.song;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Artist {
    private String name;
    private Country country;
    private List<Album> albums;

    public Artist(String name, Country country) {
        this.name = name;
        this.country = country;
        albums = new ArrayList<>();
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

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void addNewAlbum(Album album){
        if (albums.isEmpty()){
            albums.add(album);
            return;
        } else if (!albums.contains(album)) {
            albums.add(album);
            return;
        }
        throw new IllegalStateException("Album is Added: " + album.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(name, artist.name) && country == artist.country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
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
