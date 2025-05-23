package app.dao;

import db.SQLiteConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public  class MediaPlayerDAOImplementation implements MediaPlayerHistoryDAO {
    static Connection conn = SQLiteConnector.getConnection();

    @Override
    public void saveSongToHistory(LocalDateTime dateListened, Integer songId, Integer memberId) throws SQLException {
        String query = "INSERT INTO LISTENING_HISTORY (date_listened, song_id, member_id) " +
                "VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setTimestamp(1, Timestamp.valueOf(dateListened));
        ps.setInt(2, songId);
        ps.setInt(3, memberId);
        ps.executeUpdate();
    }
}
