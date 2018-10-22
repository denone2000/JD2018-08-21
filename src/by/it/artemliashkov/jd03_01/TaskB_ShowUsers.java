package by.it.artemliashkov.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskB_ShowUsers {
    static void showUsers() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (TaskC_ConnectionDB.URL_DB, TaskC_ConnectionDB.USER_DB, TaskC_ConnectionDB.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeQuery("USE `mydb`;");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Agents;");
            while (resultSet.next()) {
                String out = resultSet.getString("name") + ", " + resultSet.getString("address");
                System.out.println(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
