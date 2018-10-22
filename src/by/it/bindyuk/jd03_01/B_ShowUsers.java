package by.it.bindyuk.jd03_01;

import java.sql.*;

class B_ShowUsers {

    static void showUsers() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()
        ) {

            //==========================================================================================================
            //выводим в консоль все поля юзера
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()){
                String out = resultSet.getString("login") + ", " + resultSet.getString("password")
                        + ", " + resultSet.getString("email") + ", " + resultSet.getString("passport series")
                        + ", " + resultSet.getInt("passport id") + ", " + resultSet.getString("bancard number")
                        + ", " + resultSet.getInt("cid");
                System.out.println(out);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
