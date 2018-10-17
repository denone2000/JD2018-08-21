package by.it.bindyuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {

    public static void addUser() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        ) {

            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `bindyuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'fedor', 'yafedor', 'fedorthebest@gmail.com', 2);");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
