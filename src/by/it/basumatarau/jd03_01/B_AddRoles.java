package by.it.basumatarau.jd03_01;

import java.sql.*;

class B_AddRoles {

    static void addRoles(String roleName){
        String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
                "?useUnicode=true&characterEncoding=UTF-8";
        String USER_DB = "root";
        String PASSWORD_DB = "";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("DB driver loading error: "+ e);
        }

        try (Connection connection =
                     DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)
        ){
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO `basumatarau`.`Roles` (`ID`, `Role`) VALUES (DEFAULT, '"+roleName+"');");
            System.out.printf("new role %s - has been added... \n", roleName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
