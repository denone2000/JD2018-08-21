package by.it.basumatarau.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddUser {

    static void addUser(String login, String pwd, String email){
        addUser(login, pwd, email, 2);
    }

    static void addUser(String login, String pwd, String email, int roleID){
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
                            "INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, '%s', '%s', '%s', %d);",
                            login, pwd, email, roleID)
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
