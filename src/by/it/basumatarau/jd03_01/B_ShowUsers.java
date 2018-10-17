package by.it.basumatarau.jd03_01;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

class B_ShowUsers {

    static void showUsers(){
        String URL_DB = "jdbc:mysql://127.0.0.1:2016/basumatarau" +
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

            HashMap<Integer, String> roles= new HashMap<>();
            ResultSet usrRoles = statement.executeQuery("SELECT * FROM `Roles`;");
            while(usrRoles.next()) {
                roles.put(usrRoles.getInt("ID"), usrRoles.getString("Role"));
            }

            ResultSet resultSet = statement.executeQuery("SELECT * FROM `Users`;");
            while(resultSet.next()){
                String currUsrRole="n/a";
                for (Map.Entry<Integer, String> role : roles.entrySet()) {
                    if(role.getKey()==resultSet.getInt("Roles_ID")){
                        currUsrRole=role.getValue();
                        break;
                    }
                }

                System.out.printf("Role: %s, username: %s, email: %s",
                        currUsrRole,
                        resultSet.getString("Login"),
                        resultSet.getString("Email")+
                                "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
