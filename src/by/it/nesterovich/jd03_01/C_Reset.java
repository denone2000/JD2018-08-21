package by.it.nesterovich.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class C_Reset {

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection
                             (CN_DB.URL_DB, CN_DB.USER_DB, CN_DB.PASSWORD_DB);
             Statement statement = connection.createStatement();) {

            statement.executeUpdate(
                    "DROP SCHEMA IF EXISTS `nesterovich` ;"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
