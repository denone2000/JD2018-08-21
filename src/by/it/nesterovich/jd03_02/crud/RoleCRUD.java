package by.it.nesterovich.jd03_02.crud;

import by.it.nesterovich.jd03_02.ConnectionCreator;
import by.it.nesterovich.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {

    public  static boolean create(Role role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "INSERT INTO `roles`(`role`)" +
                            " VALUES ('%s'); ",
                    role.getRole());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    role.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public static Role read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `roles` WHERE `id`=%d ", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("role")
                );
            }
            return null;
        }
    }

    public static boolean update(Role role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `roles` SET " +
                            "`role`='%s' WHERE `id`=%d",
                    role.getRole(),
                    role.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static boolean delete(Role role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `roles` WHERE `id`=%d",
                    role.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        Role role = new Role(0, "superpuper");
        if (create(role)) {
            System.out.println("Create OK: " + role);
        }
        long id = role.getId();
        role = read(id);
        if (role != null) {
            System.out.println("Read OK: " + role);
        }
        role.setRole("superpuper2");
        if (update(role)) {
            System.out.println("Update OK: " + role);
        }
        if (delete(role)) {
            System.out.println("Delete OK: " + role);
        }
    }
}
