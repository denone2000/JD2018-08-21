package by.it.korolchuk.jd03_02;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionCreator {

    private static String URL_DB = "jdbc:mysql://127.0.0.1:2016/korolchuk" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static String USER_DB = "root";
    private static String PASSWORD_DB = "";


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }


     private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
           connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        }
        return connection;
    }
    }
