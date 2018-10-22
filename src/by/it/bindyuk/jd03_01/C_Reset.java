package by.it.bindyuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Reset {

    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    static void resetBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement()
        ) {

            //==========================================================================================================
            //сначала удаляем таблицы, затем всю схему
            statement.executeUpdate("DROP TABLE IF EXISTS `bindyuk`.`tickets` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `bindyuk`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `bindyuk`.`routes` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `bindyuk`.`roles` ;");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `bindyuk` ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
