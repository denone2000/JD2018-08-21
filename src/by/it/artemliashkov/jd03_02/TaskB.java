package by.it.artemliashkov.jd03_02;

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
            String sql = "SELECT agents.name, Role.role FROM agents JOIN Role ON agents.role_id=Role.role_id";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                System.out.printf("login: %s, role: %s\n", name, role);
            }
            System.out.println();
            sql = "SELECT COUNT(*) FROM agents";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("All users: " + resultSet.getString(1));
            }
            sql = "SELECT COUNT(*) FROM Role";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("All roles: " + resultSet.getString(1));
            }
        }
    }
}