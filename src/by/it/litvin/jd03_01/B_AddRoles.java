package by.it.litvin.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

 class B_AddRoles {

    static void addRoles(String roleName) {

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

        String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
                "?useUnicode=true&characterEncoding=UTF-8";
        String USER_DB = "root";
        String PASSWORD_DB = "";
        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB)){
            Statement statement = connection.createStatement();


                    statement.executeUpdate("INSERT INTO `litvin`.`roles` (`ID`, `Role`) VALUES (DEFAULT, '"+roleName+"');");
            System.out.println("Added role is "+roleName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
