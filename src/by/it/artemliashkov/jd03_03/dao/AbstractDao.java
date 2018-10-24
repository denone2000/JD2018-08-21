package by.it.artemliashkov.jd03_03.dao;

import by.it.artemliashkov.jd03_03.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class AbstractDao {

    int executeUpdate(String sql) {
        int result = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            result = statement.executeUpdate(sql);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}