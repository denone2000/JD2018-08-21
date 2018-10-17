package by.it.basumatarau.jd03_01;

import java.sql.*;

class B_ShowUsers {

    static void showUsers(){
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
            System.out.println("User list:");

            System.out.println(statement.isClosed());

            ResultSet resultSet = statement.executeQuery("select * from Users;");

            while(resultSet.next()){
                int userID = resultSet.getInt("ID");
                System.out.printf("Role: %s, username: %s, email: %s",
                        statement.executeQuery(
                                String.format("SELECT * FROM `Roles` WHERE `ID`=%d;",
                                        userID)
                        ).getString("Role"),
                        resultSet.getString("Login"),
                        resultSet.getString("Email")+
                                "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
