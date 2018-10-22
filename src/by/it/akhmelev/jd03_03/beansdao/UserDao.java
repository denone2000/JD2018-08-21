package by.it.akhmelev.jd03_03.beansdao;

import by.it.akhmelev.jd03_03.ConnectionCreator;
import by.it.akhmelev.jd03_03.InterfaceDao;
import by.it.akhmelev.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao implements InterfaceDao<User> {
    @Override
    public List<User> getAll(String WHERE) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRoles_Id(rs.getLong("roles_id"));
                users.add(user);
            }
            return users;
        }
    }

    @Override
    public User read(long id) throws SQLException {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "insert INTO users(Login,Password,Email,roles_id)" +
                        " values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_Id()
        );
        long id = executeUpdate(sql);
        if (id > 0) user.setId(id);
        return id > 0;
}

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET `login` = '%s', `password` = '%s', `email` = '%s', `roles_id` = '%d' WHERE `users`.`id` = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_Id(), user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`ID` = %d;", user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }


}
