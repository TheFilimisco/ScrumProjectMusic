package dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    public T createItem(T t) throws SQLException;
    public void deleteItem(int idItem) throws SQLException;
    public T readItem(int idItem) throws SQLException;
    public void updateItem(T t) throws SQLException;
    public List<T> getItems() throws SQLException;
}
