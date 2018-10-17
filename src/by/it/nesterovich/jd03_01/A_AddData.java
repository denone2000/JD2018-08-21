package by.it.nesterovich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

class A_AddData {

    static void addData(int code, double cost, String usersId, String filmsId, String cinemasId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO `nesterovich`.`reserved_tickets` (`id`, `code`, `cost`, `users_id`, `films_id`, `cinemas_id`) VALUES (DEFAULT");
        stringBuilder.append(", ").append(code);
        stringBuilder.append(", ").append(cost);
        stringBuilder.append(", ").append(usersId);
        stringBuilder.append(", ").append(filmsId);
        stringBuilder.append(", ").append(cinemasId);
        stringBuilder.append(");");

        addDataInDB(String.valueOf(stringBuilder));
    }

    private static void addDataInDB(String sqlCommand) {
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
