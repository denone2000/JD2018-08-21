package by.it.litvin.jd03_02;

import by.it.litvin.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCrud {

    public static void main(String[] args) throws SQLException {

        User user = new User(0, "login", "login", "login@mail.ru", 2);
        if (create(user))
            System.out.println("Create " + user);
        long id = user.getId();
        user = read(id);
        if (user != null)
            System.out.println("Read " + user);
        user.setEmail("creator2@mail.ru");
        if (update(user))
            System.out.println("Update " + user);
        if (delete(user))
            System.out.println("Delete " + user);
    }


    private static User read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `users` WHERE `id`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("roles_id")
                );
            }
            return null;
        }


    }

    private static boolean update(User user) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `users` SET " +
                            "`login`='%s'," +
                            "`password`='%s'," +
                            "`email`='%s'," +
                            "`roles_id`=%d WHERE `id`=%d",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getRoles_id(),
                    user.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    private static boolean delete(User user) throws SQLException {
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

     static boolean create(User user) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "INSERT INTO `users`(`login`,`password`,`email`,`roles_id`)" +
                            " VALUES ('%s','%s','%s',%d);",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getRoles_id());
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
}

