package by.it.galushka.jd03_02;

import by.it.galushka.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class RoleCRUD {

    static boolean createRole(Role role) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `roles`(`Role`) " +
                    "VALUES ('%s');", role.getRole());
            System.out.println(sql);
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    role.setID(keys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    static Role read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `roles` WHERE `ID`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Role(
                        resultSet.getLong("ID"),
                        resultSet.getString("Role")
                );
            }
        }
        return null;
    }

    static boolean update(Role role) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format("UPDATE `roles` SET `Role`='%s' " +
                    "WHERE `ID`=%d", role.getRole(), role.getID());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    static boolean delete(Role role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `roles` WHERE `ID`=%d", role.getID());
            return (statement.executeUpdate(sql) == 1);
        }
    }
}