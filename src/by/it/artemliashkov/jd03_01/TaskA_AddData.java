package by.it.artemliashkov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA_AddData {
    static void addData(String name, String type, int amount_agents, String address,int Agents_id){
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
                            "INSERT INTO `mydb`.`Company` (`id`, `name`, `type`, `amount_agents`, `address`, `Agents_id`) VALUES (DEFAULT, '%s', '%s', '%s', '%s', '%s');\n",
                            name, type, amount_agents, address,  Agents_id)
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
