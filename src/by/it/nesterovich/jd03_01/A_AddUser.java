package by.it.nesterovich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

class A_AddUser {

    static void addUser(String login, String password, String email) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) VALUES (DEFAULT");
        stringBuilder.append(", \'").append(login).append('\'');
        stringBuilder.append(", \'").append(password).append('\'');
        stringBuilder.append(", \'").append(email).append('\'');
        stringBuilder.append(", ").append("NULL");
        stringBuilder.append(", ").append("NULL");
        stringBuilder.append(", ").append("NULL");
        stringBuilder.append(", 2);");

        addUserInDB(String.valueOf(stringBuilder));
    }

    static void addUser(String login, String password, String email, String firstName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) VALUES (DEFAULT");
        stringBuilder.append(", \'").append(login).append('\'');
        stringBuilder.append(", \'").append(password).append('\'');
        stringBuilder.append(", \'").append(email).append('\'');
        stringBuilder.append(", \'").append(firstName).append('\'');
        stringBuilder.append(", ").append("NULL");
        stringBuilder.append(", ").append("NULL");
        stringBuilder.append(", 2);");

        addUserInDB(String.valueOf(stringBuilder));
    }

    static void addUser(String login, String password, String email, String firstName, String lastName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) VALUES (DEFAULT");
        stringBuilder.append(", \'").append(login).append('\'');
        stringBuilder.append(", \'").append(password).append('\'');
        stringBuilder.append(", \'").append(email).append('\'');
        stringBuilder.append(", \'").append(firstName).append('\'');
        stringBuilder.append(", \'").append(lastName).append('\'');
        stringBuilder.append(", ").append("NULL");
        stringBuilder.append(", 2);");

        addUserInDB(String.valueOf(stringBuilder));
    }

    static void addUser(String login, String password, String email, String firstName, String lastName, int phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) VALUES (DEFAULT");
        stringBuilder.append(", \'").append(login).append('\'');
        stringBuilder.append(", \'").append(password).append('\'');
        stringBuilder.append(", \'").append(email).append('\'');
        stringBuilder.append(", \'").append(firstName).append('\'');
        stringBuilder.append(", \'").append(lastName).append('\'');
        stringBuilder.append(", \'").append(phoneNumber).append('\'');
        stringBuilder.append(", 2);");

        addUserInDB(String.valueOf(stringBuilder));
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
