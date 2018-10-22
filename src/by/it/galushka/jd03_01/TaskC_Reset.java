package by.it.galushka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC_Reset {
    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `galushka` ;");
            System.out.println("--->Reset DataBase done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
