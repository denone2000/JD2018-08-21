package by.it.galushka.jd03_02;

import java.sql.*;
import java.util.*;

public class TaskB {

    static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/galushka" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static final String USER_DB = "root";
    static final String PASSWORD_DB = "";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement()
        ) {
            Map<Long, String> roles = new HashMap<>();
            ResultSet resultSetRoles = statement.executeQuery("select * from roles;");
            while (resultSetRoles.next()) {
                long id = resultSetRoles.getLong("ID");
                String role = resultSetRoles.getString("Role");
                roles.put(id, role);
            }
            ResultSet resultSetUsers = statement.executeQuery("select * from users");
//            Map<String, Long> users = new HashMap<>();
            System.out.printf("%-10s %-15s\n", "User:", "Role:");
            System.out.println("==================================");
            List users = new ArrayList();
            while (resultSetUsers.next()) {
//                long roles_id = resultSetUsers.getLong("roles_ID");
//                String login = resultSetUsers.getString("Login");
//                users.put(login, roles_id);
                String role = "null";
                int count = 1;
                long roles_id = resultSetUsers.getLong("roles_ID");
                users.add(resultSetUsers.getString("Login"));
                Set<Map.Entry<Long, String>> entries = roles.entrySet();
                for (Map.Entry<Long, String> entry : entries) {
                    long key = entry.getKey();
                    if (key == roles_id) {
                        role = roles.get(key);
                    }
                }
                System.out.printf("%-10s %-15s\n",
                        resultSetUsers.getString("login"),
                        role);
            }
            System.out.println("==================================");
            System.out.println("Total users: " + users.size());
            System.out.println("Total roles: " + roles.size());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
