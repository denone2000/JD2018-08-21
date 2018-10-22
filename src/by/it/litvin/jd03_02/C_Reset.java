package by.it.litvin.jd03_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Reset {

   static void reset() {
       String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
               "?useUnicode=true&characterEncoding=UTF-8";
       String USER_DB = "root";
       String PASSWORD_DB = "";
       try(Connection connection=
                   DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
           Statement statement=connection.createStatement()){
//            statement.executeUpdate("DROP SCHEMA IF EXISTS `litvin` ;");
           statement.executeUpdate("DROP TABLE IF EXISTS `litvin`.`form` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `litvin`.`roles` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `litvin`.`users` ;");
           System.out.println("Schema or choosen table is deleted");
       }catch (SQLException e){
           e.printStackTrace();
       }

       }
}
