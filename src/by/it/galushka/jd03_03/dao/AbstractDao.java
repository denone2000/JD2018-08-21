package by.it.galushka.jd03_03.dao;

import by.it.galushka.jd03_03.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class AbstractDao {

    long executeUpdate(String sql) throws SQLException {
        long result = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            result = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (result == 1 && sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next())
                    result = resultSet.getLong(1);
            }
        }
        return result;
    }
}
