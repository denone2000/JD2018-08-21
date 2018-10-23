package by.it.nesterovich.jd03_03.daouniversal;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<TYPE> {

    boolean create(TYPE entity) throws SQLException;

    TYPE read(int id) throws SQLException;

    boolean update(TYPE entity) throws SQLException;

    boolean delete(TYPE entity) throws SQLException;

    List<TYPE> getAll(String whereAndOrder) throws SQLException;
}
