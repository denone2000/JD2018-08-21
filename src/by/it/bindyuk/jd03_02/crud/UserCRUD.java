package by.it.bindyuk.jd03_02.crud;

import by.it.bindyuk.jd03_02.ConnectionCreator;
import by.it.bindyuk.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    //==================================================================================================================
    //новый пользователь
    public static boolean create(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `users`(`login`, `password`, `email`, `passport series`," +
                            " `passport id`, `bancard number`, `cid`, `roles_id`) " +
                            "VALUES ('%s','%s','%s','%s','%d','%s','%d','%d');",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getPasspostSeries(),
                    user.getPassportId(),
                    user.getBancardNumber(),
                    user.getCid(),
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

    //==================================================================================================================
    //прочитать пользователя из бд по id
    public static User read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `users` WHERE `id`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("passport series"),
                        resultSet.getInt("passport id"),
                        resultSet.getString("bancard number"),
                        resultSet.getInt("cid"),
                        resultSet.getLong("roles_id"));
            }
            return null;
        }
    }

    //==================================================================================================================
    //перезаписать пользователя
    public static boolean update(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `users` SET " +
                            "`login`='%s'," +
                            "`password`='%s'," +
                            "`email`='%s'," +
                            "`passport series`='%s'," +
                            "`passport id`='%d'," +
                            "`bancard number`='%s'," +
                            "`cid`='%d'," +
                            "`roles_id`='%d' " +
                            "WHERE `id`=%d",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getPasspostSeries(),
                    user.getPassportId(),
                    user.getBancardNumber(),
                    user.getCid(),
                    user.getRoles_id(),
                    user.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    //==================================================================================================================
    //удалить пользователя
    public static boolean delete(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = String.format("DELETE FROM `users` WHERE `id`=%d",
                    user.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    @SuppressWarnings("all")
    public static void main(String[] args) throws SQLException {
        User user = new User(0, "jun", "junpass",
                "junior@gmail.com", "MP",
                2653344, "0001 0002 0003 0004", 840, 2);

        if (create(user)) {
            System.out.println("ALL IS OKEY!" + '\n' + user);
        }
        long id = user.getId();
        user = read(id);
        if (user != null) {
            System.out.println("READING IS OKEY" + '\n' + user);
        }
        user.setEmail("rerwer@tut.by");
        if (update(user)) {
            System.out.println("UPDATING IS OK" + '\n' + user);
        }
        if (delete(user)) {
            System.out.println("DELETE" + '\n' + user);
        }
    }
}
