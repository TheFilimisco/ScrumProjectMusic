package models.song;

public class Artist {
    private Integer idArtist;
    private String nameArtist;
    private Country country;

    public Artist(Integer idArtist, String nameArtist, Country country) {
        this.idArtist = idArtist;
        this.nameArtist = nameArtist;
        this.country = country;
    }

    public Artist() {
    }

    public Integer getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(Integer idArtist) {
        this.idArtist = idArtist;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "idArtist=" + idArtist +
                ", nameArtist='" + nameArtist + '\'' +
                ", country=" + country +
                '}';
    }
}