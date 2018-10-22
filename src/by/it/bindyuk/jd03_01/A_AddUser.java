package by.it.bindyuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddUser {

    static void addUser() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("INSERT INTO `bindyuk`.`users` (`id`, `login`, `password`, `email`, `passport series`, `passport id`, `bancard number`, `cid`, `roles_id`)" +
                    "VALUES (DEFAULT, 'igor', 'igorspace', 'igorigor@gmail.com', 'MP', 2566012, '0004 0006 0009 0005', 980, 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
