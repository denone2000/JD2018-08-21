package by.it.bindyuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddData {
    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    static void addData() {

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


            statement.executeUpdate("INSERT INTO `bindyuk`.`tickets` (`id`, `transport`, `routes_id from`, `routes_id to`, `data`, `month`, `year`, `users_id`)" +
                    "VALUES (DEFAULT, 'train', 2, 3, 6, 11, 2018, 3);");

            statement.executeUpdate("INSERT INTO `bindyuk`.`tickets` (`id`, `transport`, `routes_id from`, `routes_id to`, `data`, `month`, `year`, `users_id`)" +
                    "VALUES (DEFAULT, 'bus', 4, 5, 9, 01, 2019, 3);");

            statement.executeUpdate("INSERT INTO `bindyuk`.`tickets` (`id`, `transport`, `routes_id from`, `routes_id to`, `data`, `month`, `year`, `users_id`)" +
                    "VALUES (DEFAULT, 'plain', 2, 1, 1, 12, 2019, 3);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
