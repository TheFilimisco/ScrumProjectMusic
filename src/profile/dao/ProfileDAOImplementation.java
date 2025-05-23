package profile.dao;

import db.SQLiteConnector;
import models.dao.*;
import models.dao.interfaces.GenericDAO;
import models.song.Album;
import models.song.Artist;
import models.song.Genre;
import models.song.Song;
import models.user.Member;
import org.ietf.jgss.GSSName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAOImplementation implements ProfileDAO {

    static Connection conn = SQLiteConnector.getConnection();
    GenericDAO<Member> memberDAO = new MemberDAOImplementation();
    GenericDAO<Artist> artistDAO = new ArtistDAOImplementation();
    GenericDAO<Genre> genreDAO = new GenreDAOImplementation();
    GenericDAO<Album> albumDAO = new AlbumDAOImplementation();

    @Override
    public void updateInformationProfile(Member member) throws SQLException {
        memberDAO.updateItem(member);
    }

    @Override
    public void deleteProfile(Integer idMember) throws SQLException {
        memberDAO.deleteItem(idMember);
    }

    @Override
    public List<Song> getHistoryProfile(Integer idMember) throws SQLException {
        String query = "SELECT S.* FROM LISTENING_HISTORY L JOIN SONGS S ON(L.song_id = S.id_song) WHERE member_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idMember);
        ResultSet rs = ps.executeQuery();
        List<Song> songs = new ArrayList<>();
        while (rs.next()) {
            Song song = new Song();
            song.setIdSong(rs.getInt("id_song"));
            song.setTitleSong(rs.getString("title_song"));
            song.setDuration(rs.getInt("duration"));
            song.setArtist(artistDAO.readItem(rs.getInt("artist_id")));
            song.setGenre(genreDAO.readItem(rs.getInt("genre_id")));
            song.setAlbum(albumDAO.readItem(rs.getInt("album_id")));
            songs.add(song);
        }
        if (songs.isEmpty()) {
            return null;
        }
        return songs;
    }
}
