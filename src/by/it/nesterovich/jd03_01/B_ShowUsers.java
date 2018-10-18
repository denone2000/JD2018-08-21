package by.it.nesterovich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

class B_ShowUsers {

    static void showUsers() {
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
            statement.executeQuery("USE `nesterovich`;");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
            while (resultSet.next()) {
                String out = resultSet.getString("email") + ", " + resultSet.getString("login");
                System.out.println(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
