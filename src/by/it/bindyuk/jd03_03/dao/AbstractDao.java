package by.it.bindyuk.jd03_03.dao;

import by.it.bindyuk.jd03_03.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao {

    //==================================================================================================================
    //метод для SOLID, получаем id из бина
    protected long executeCreate(String sql) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        return -1;
    }

    //==================================================================================================================
    //метод для SOLID, узнаем, был ли изменен бин
    protected boolean executeUpdate(String sql) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            return (statement.executeUpdate(sql) > 0);
        }
    }
}
