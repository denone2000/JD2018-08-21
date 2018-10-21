package by.it.voinilo.jd03.jd03_02.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreater {

    static private Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (CN.URL_DB) {
                if (connection == null || connection.isClosed()){
                    connection= DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                }
                connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            }
        }
        return connection;

    }

}

