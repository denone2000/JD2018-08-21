package by.it.galushka.jd03_02;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionCreator {
    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/galushka" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    //сделать регистрацию

    private static Connection connection;

//    Connection getConnection() {
//        if (connection == null || connection.isClosed()) {
//            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
//        }
//    }
}
