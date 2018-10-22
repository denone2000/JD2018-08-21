package by.it.galushka.jd03_01;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TaskB_ShowUsers {

    static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/galushka" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static final String USER_DB = "root";
    static final String PASSWORD_DB = "";

    public static void showUsers() {
        try (Connection connection =
                     DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)
        ) {
            Statement statement = connection.createStatement();
            ResultSet resultSetRoles = statement.executeQuery("select * from roles;");
            Map<Integer, String> map = new HashMap<>();
            while (resultSetRoles.next()) {
                map.put(resultSetRoles.getInt("ID"), resultSetRoles.getString("Role"));
            }
            ResultSet resultSetUsers = statement.executeQuery("select * from users");
            System.out.printf("%-15s %-10s %-10s\n", "Role:", "Login:", "Email:");
            while (resultSetUsers.next()) {
                String role = "null";
                int roles_id = resultSetUsers.getInt("roles_ID");
                Set<Map.Entry<Integer, String>> entries = map.entrySet();
                for (Map.Entry<Integer, String> entry : entries) {
                    int key = entry.getKey();
                    if(key == roles_id){
                        role = map.get(key);
                    }
                }
                System.out.printf("%-15s %-10s %-10s\n", role,
                        resultSetUsers.getString("login"),
                        resultSetUsers.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
