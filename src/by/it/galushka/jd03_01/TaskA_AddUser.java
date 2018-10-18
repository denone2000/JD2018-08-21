package by.it.galushka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA_AddUser {

    public static void addUsers() {
        try (Connection connection =
                     DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `galushka`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user2', 'puser2', 'user2@it.by', 2);");
            statement.executeUpdate("INSERT INTO `galushka`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'moder', 'pmoder', 'moder@it.by', 4);");
            System.out.println("--->Users added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
