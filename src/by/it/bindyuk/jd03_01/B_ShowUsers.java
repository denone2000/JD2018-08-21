package by.it.bindyuk.jd03_01;

import java.sql.*;

public class B_ShowUsers {

    public static void showUsers() {

//        Driver driver = new FabricMySQLDriver();
//        DriverManager.registerDriver(driver);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        ) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()){
                String out = resultSet.getString("login") + ", " + resultSet.getString("password")
                        + ", " + resultSet.getString("email");
                System.out.println(out);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
