package by.it.galushka.jd03_02;

import by.it.galushka.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    static boolean create(User user) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `users`(`Login`, `Password`, `Email`, `roles_ID`) " +
                            "VALUES ('%s','%s','%s','%d')",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getRoles_Id());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setID(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    static User read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `users` WHERE `ID`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new User (
                        resultSet.getLong("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getString("Email"),
                        resultSet.getLong("roles_ID")
                );
            }
            return null;
        }
    }

    static boolean update(User user) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("UPDATE `users` SET `Login`='%s'," +
                    "`Password`='%s',`Email`='%s',`roles_ID`=%d WHERE `ID`=%d",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getRoles_Id(),
                    user.getID());
            return (statement.executeUpdate(sql) == 1);
        }

    }

    static boolean delete(User user) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `users` WHERE `ID`=%d",
                    user.getID());
            return (statement.executeUpdate(sql) == 1);
        }
    }
}
