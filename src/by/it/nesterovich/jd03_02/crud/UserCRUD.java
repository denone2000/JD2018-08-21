package by.it.nesterovich.jd03_02.crud;

import by.it.nesterovich.jd03_02.ConnectionCreator;
import by.it.nesterovich.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    public static boolean create(User user) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "INSERT INTO `users`(`login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`)" +
                            " VALUES ('%s','%s','%s','%s','%s',%d,%d);",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getFistName(),
                    user.getLastName(),
                    user.getPhoneNumber(),
                    user.getRolesId());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public static User read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `users` WHERE `id`=%d ", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("phoneNumber"),
                        resultSet.getLong("roles_id")
                );
            }
            return null;
        }
    }

    public static boolean update(User user) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `users` SET " +
                            "`login`='%s'," +
                            "`password`='%s'," +
                            "`email`='%s'," +
                            "`firstName`='%s'," +
                            "`lastName`='%s'," +
                            "`phoneNumber`=%d," +
                            "`roles_id`=%d WHERE `id`=%d",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getFistName(),
                    user.getLastName(),
                    user.getPhoneNumber(),
                    user.getRolesId(),
                    user.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static boolean delete(User user) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `users` WHERE `id`=%d",
                    user.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        User user = new User(0, "loginjava", "qwerty", "aaaa@aaaa.aa", "Alex", 2);
        if (create(user)) {
            System.out.println("Create OK: " + user);
        }
        long id = user.getId();
        user = read(id);
        if (user != null) {
            System.out.println("Read OK: " + user);
        }
        user.setEmail("bbbb@bbb.bb");
        user.setLastName("Bosh");
        user.setPhoneNumber(12345678);
        if (update(user)) {
            System.out.println("Update OK: " + user);
        }
        if (delete(user)) {
            System.out.println("Delete OK: " + user);
        }
    }
}
