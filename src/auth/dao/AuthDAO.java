package auth.dao;

import models.song.Album;
import models.user.Member;

import java.sql.SQLException;

public interface AuthDAO {
    public Member findByEmail(String email) throws SQLException;
}
