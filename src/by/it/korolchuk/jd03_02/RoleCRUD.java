package by.it.korolchuk.jd03_02;

import by.it.korolchuk.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {
    static boolean create(Role role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "INSERT INTO `roles`(`role`)" +
                            " VALUES ('%s');",
                    role.getRole());
            System.out.println(sql);
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


    static Role read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `roles` WHERE `id`=%d", id);
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

    static boolean update(Role role) throws SQLException {
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

    static boolean delete(Role role) throws SQLException {
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
        if (create(role))
            System.out.println("Create OK: " + role);
        long id = role.getId();
        role = null;
        role = read(id);
        if (role != null)
            System.out.println("Read OK: " + role);
        if (role != null) {
            role.setRole("superpuper2");
        }
        if (role != null && update(role)) System.out.println("Update OK: " + role);
        if (role != null && delete(role)) System.out.println("Delete OK: " + role);
    }

}
