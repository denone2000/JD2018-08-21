package by.it.litvin.jd03_03.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    //func
    private static Connection connection;

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String URL_DB = "jdbc:mysql://127.0.0.1:2016/litvin" +
                    "?useUnicode=true&characterEncoding=UTF-8";
            String USER_DB = "root";
            String PASSWORD_DB = "";
            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);

        }
        return connection;
    }

}
