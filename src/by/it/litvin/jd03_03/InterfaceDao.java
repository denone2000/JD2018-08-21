package by.it.litvin.jd03_03;


import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<T> {
    T read(long id) throws SQLException;

    boolean create(T entity) throws SQLException;

    boolean update(T entity) throws SQLException;

    boolean delete(T entity) throws SQLException;

    List<T> getAll(String whereString) throws SQLException;

}
