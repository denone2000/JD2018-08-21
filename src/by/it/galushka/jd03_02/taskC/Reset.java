package by.it.galushka.jd03_02.taskC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {
    static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/galushka" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static final String USER_DB = "root";
    static final String PASSWORD_DB = "";

    public static void reset() {
        try (Connection connection =
                     DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `galushka` ;");
            System.out.println("--->Reset DataBase done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
