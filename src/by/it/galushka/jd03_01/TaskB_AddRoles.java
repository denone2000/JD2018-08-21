package by.it.galushka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB_AddRoles {

    public static void addRoles() {
        try (Connection connection =
                     DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `galushka`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Moderator');");
            System.out.println("--->Roles added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
