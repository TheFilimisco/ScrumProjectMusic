package dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    public Integer createItem(T t) throws SQLException;
    public void deleteItem(Integer idItem) throws SQLException;
    public T readItem(Integer idItem) throws SQLException;
    public void updateItem(T t) throws SQLException;
    public List<T> getItems() throws SQLException;
}
