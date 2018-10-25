package by.it.korolchuk.jd03_03.entityDAO;

import by.it.korolchuk.jd03_03.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDao {


    protected long executeUpdate(String sql) throws SQLException {
        long result;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            result = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            System.out.println(sql);
            if (result == 1 && sql.trim().toUpperCase().startsWith("INSERT ")) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    result = generatedKeys.getLong(1);
                }
            }
        }
        return result;
    }

}
