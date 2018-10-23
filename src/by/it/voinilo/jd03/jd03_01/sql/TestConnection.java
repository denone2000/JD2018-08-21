package by.it.voinilo.jd03.jd03_01.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestConnection implements CN {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        ) {
            if (connection.isClosed())
            {
                System.out.println("connection is closed");
            }
            else
            {
                System.out.println("connection is open");
            }
        }
    }
}
