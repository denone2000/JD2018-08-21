package by.it.galushka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `galushka`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user2', 'puser2', 'user2@it.by', 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
