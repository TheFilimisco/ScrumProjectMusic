package app.dao;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface MediaPlayerHistoryDAO {
    void saveSongToHistory(LocalDateTime dateListened,Integer songId, Integer memberId) throws SQLException;
}
