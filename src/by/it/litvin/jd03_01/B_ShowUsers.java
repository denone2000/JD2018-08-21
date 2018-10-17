package by.it.litvin.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

 class B_ShowUsers {

     static void showUsers () {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

         String PASSWORD_DB = "";
         String USER_DB = "root";
         String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
                 "?useUnicode=true&characterEncoding=UTF-8";
         try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB)){
            Statement statement = connection.createStatement();
            statement.executeQuery("USE `litvin`;");
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                String out = resultSet.getString("email") + ", " + resultSet.getString("login");
                System.out.println(out);}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

