package by.it.artemliashkov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TaskC_Reset {
    static void cReset() {
        try (Connection connection =
                     DriverManager.getConnection
                             (TaskC_ConnectionDB.URL_DB, TaskC_ConnectionDB.USER_DB, TaskC_ConnectionDB.PASSWORD_DB);
             Statement statement = connection.createStatement();) {

            statement.executeUpdate("DROP SCHEMA IF EXISTS `mydb` ;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
