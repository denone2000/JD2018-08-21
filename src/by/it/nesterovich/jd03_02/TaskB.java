package by.it.nesterovich.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {

    public static void main(String[] args) throws SQLException {
        outUsers();
    }

    private static void outUsers() throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = "SELECT users.login, roles.role FROM users JOIN roles ON users.roles_id=roles.id";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String role = resultSet.getString("role");
                System.out.printf("login: %s, role: %s\n", login, role);
            }
            System.out.println();
            sql = "SELECT COUNT(*) FROM users";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("All users: " + resultSet.getString(1));
            }
            sql = "SELECT COUNT(*) FROM roles";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("All roles: " + resultSet.getString(1));
            }
        }
    }
}
