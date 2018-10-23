package by.it.basumatarau.jd03_03.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    private static String URL_DB = "jdbc:mysql://127.0.0.1:2016/basumatarau" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static String USER_DB = "root";
    private static String PASSWORD_DB = "";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection==null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            System.out.println("connection created...");
        }
        return connection;
    }
}
