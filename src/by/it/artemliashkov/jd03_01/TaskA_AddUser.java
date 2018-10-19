package by.it.artemliashkov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA_AddUser {
    static void addUser(String name, String address){
        addUser(name, address,  2);
    }

    static void addUser(String name, String address, int roleID){
        String URL_DB = "jdbc:mysql://127.0.0.1:2016"+
                "?useUnicode=true&characterEncoding=UTF-8";
        String USER_DB = "root";
        String PASSWORD_DB = "";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("DB driver loading error: "+ e);
        }

        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)){
            Statement statement = connection.createStatement();

            statement.executeUpdate(
                    String.format(
                            "INSERT INTO `mydb`.`Agents` (`Agents_id`, `name`, `address`, `Role_id`) VALUES (DEFAULT, '%s', '%s',  %d);",
                            name, address,  roleID)
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

