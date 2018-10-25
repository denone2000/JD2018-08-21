package by.it.korolchuk.jd03_03.entityDAO;

import by.it.korolchuk.jd03_03.ConnectionCreator;
import by.it.korolchuk.jd03_03.InterfaceDAO;
import by.it.korolchuk.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao implements InterfaceDAO<User> {

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users`(`login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s','%s','%s',%d)",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getRolesId());
        long id = executeUpdate(sql);
        if (id > 0) {
            user.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public User read(long id) throws SQLException {
        String where = String.format("WHERE `id`=%d", id);
        List<User> users = getAll(where);
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`login`='%s'," +
                        "`password`='%s'," +
                        "`email`='%s'," +
                        "`roles_id`=%d WHERE `id`=%d",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getRolesId(),
                user.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `id`=%d",
                user.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<User> getAll(String where) throws SQLException {

        List<User> result = new ArrayList<>();
        String sql = "SELECT * FROM `users` " + where;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                result.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("roles_id")));
            }
        }
        return result;
    }
}

