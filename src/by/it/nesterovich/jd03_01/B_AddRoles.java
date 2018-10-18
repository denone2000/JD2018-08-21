package by.it.nesterovich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

class B_AddRoles {

    static void addRoles(String role) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO `nesterovich`.`roles` (`id`, `role`) VALUES (DEFAULT, ");
        stringBuilder.append('\'').append(role).append("\');");

        addRolesInDB(String.valueOf(stringBuilder));
    }

    private static void addRolesInDB(String sqlCommand) {
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

            statement.executeUpdate(sqlCommand);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
