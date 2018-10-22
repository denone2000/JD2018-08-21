package by.it.nesterovich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

class A_AddUser {

    static void addUser(String login, String password, String email) {
        String sql = String.format("INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) " +
                        "VALUES (DEFAULT, '%s', '%s', '%s', NULL, NULL, NULL, 2);",
                login, password, email);
        addUserInDB(sql);
    }

    static void addUser(String login, String password, String email, String firstName) {
        String sql = String.format("INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) " +
                        "VALUES (DEFAULT, '%s', '%s', '%s', '%s', NULL, NULL, 2);",
                login, password, email, firstName);
        addUserInDB(sql);
    }

    static void addUser(String login, String password, String email, String firstName, String lastName) {
        String sql = String.format("INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) " +
                        "VALUES (DEFAULT, '%s', '%s', '%s', '%s', '%s', NULL, 2);",
                login, password, email, firstName, lastName);
        addUserInDB(sql);
    }

    static void addUser(String login, String password, String email, String firstName, String lastName, int phoneNumber) {
        String sql = String.format("INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) " +
                        "VALUES (DEFAULT, '%s', '%s', '%s', '%s', '%s', %d, 2);",
                login, password, email, firstName, lastName, phoneNumber);
        addUserInDB(sql);
    }

    private static void addUserInDB(String insert) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (CN_DB.URL_DB, CN_DB.USER_DB, CN_DB.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(insert);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
