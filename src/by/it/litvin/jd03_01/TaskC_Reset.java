package by.it.litvin.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC_Reset {

    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    public static void main(String[] args) {
        try(Connection connection=
                    DriverManager.getConnection(URL_DB,USER_DB,PASSWORD_DB);
            Statement statement=connection.createStatement();){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `litvin` ;");
            System.out.println("Schema is deleted");
        }catch (SQLException e){
            e.printStackTrace();
        }

        }
}
