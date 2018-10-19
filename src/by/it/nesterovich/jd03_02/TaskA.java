package by.it.nesterovich.jd03_02;

import by.it.nesterovich.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA {

    public static void main(String[] args) throws SQLException {
        System.out.println(searchIdRole("user"));
    }

    private static String searchIdRole(String role) throws SQLException {
        String resultSearch = "No role";
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT `id` FROM `roles` WHERE `role`='%s';", role);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("id");
            }
        }
        return resultSearch;
    }
}
