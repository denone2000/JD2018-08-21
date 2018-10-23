package by.it.artemliashkov.jd03_02;

import by.it.artemliashkov.jd03_02.beans.Role;

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
                    "INSERT INTO `Role`(`role`)" +
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
            String sql = String.format("SELECT * FROM `Role` WHERE `Role_id`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Role(
                        resultSet.getLong("Role_id"),
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
                    "UPDATE `Role` SET " +
                            "`role`='%s' WHERE `Role_id`=%d",
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
                    "DELETE FROM `Role` WHERE `Role_id`=%d",
                    role.getId());
            return (statement.executeUpdate(sql) == 1);
        }

    }



    public static void main(String[] args) throws SQLException {
        Role role = new Role(0, "administrator");
        if (create(role))
            System.out.println("Create OK: " + role);
        long id = role.getId();
        role=null;
        role = read(id);
        if (role!=null)
            System.out.println("Read OK: "+role);
        role.setRole("moderator");
        if (update(role))
            System.out.println("Update OK: " + role);
        if (delete(role))
            System.out.println("Delete OK: " + role);
    }

}
