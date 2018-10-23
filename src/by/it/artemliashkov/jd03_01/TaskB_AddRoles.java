package by.it.artemliashkov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB_AddRoles {
    static void addRoles(String roleName){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("DB driver loading error: "+ e);
        }

        try (Connection connection =
                     DriverManager.getConnection(TaskC_ConnectionDB.URL_DB, TaskC_ConnectionDB.USER_DB, TaskC_ConnectionDB.PASSWORD_DB)
        ){
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO `mydb`.`Role` (`Role_id`, `role`) VALUES (DEFAULT, '"+roleName+"');");
            System.out.printf("new role %s - has been added... \n", roleName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
