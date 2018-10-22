package by.it.korolchuk.jd03_03.entityDAO;

import by.it.korolchuk.jd03_03.ConnectionCreator;
import com.sun.deploy.security.ValidationState;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDao {


    long execureUodate(String sql) throws SQLException {
        long result;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            result = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (result == 1 && sql.startsWith("insert ")) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    result = generatedKeys.getLong(1);
                }
            }
        }
        return -1;
    }

}
