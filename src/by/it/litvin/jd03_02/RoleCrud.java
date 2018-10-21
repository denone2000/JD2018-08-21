package by.it.litvin.jd03_02;

import by.it.litvin.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCrud {
    public static void main(String[] args) throws SQLException {

        Role role = new Role(0, "creator");
        if (create(role))
            System.out.println("Create " + role);
        long id = role.getId();
        role = read(id);
        if (role != null)
            System.out.println("Read " + role);
        assert role != null;
        role.setRole("creator2");
        if (update(role))
            System.out.println("Update " + role);
        if (delete(role))
            System.out.println("Delete " + role);
    }


    private static Role read(long id) throws SQLException {
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
        }return null;


    }

    private static boolean update(Role role) throws SQLException {
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
}