package by.it.korolchuk.jd03_02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC {

    public static void main(String[] args) {

    }


    static boolean dropDatabase() throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "SQL DROP TABLE IF EXISTS Ads");

            return (statement.executeUpdate(sql) == 1);
        }
    }
}

