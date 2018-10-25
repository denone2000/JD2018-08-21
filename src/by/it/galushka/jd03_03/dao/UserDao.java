package by.it.galushka.jd03_03.dao;

import by.it.galushka.jd03_03.ConnectionCreator;
import by.it.galushka.jd03_03.InterfaceDao;
import by.it.galushka.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao implements InterfaceDao<User> {

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format("INSERT INTO `users`(`Login`, " +
                        "`Password`, `Email`, `roles_ID`) " +
                        "VALUES ('%s','%s','%s','%d')",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getRoles_Id());
        long id = executeUpdate(sql);
        if (id > 0) {
            user.setID(id);
        }
        return (id > 0);
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
    public boolean update(User user) throws SQLException {
        String sql = String.format("UPDATE `users` SET `Login`='%s'," +
                        "`Password`='%s',`Email`='%s',`roles_ID`=%d WHERE `ID`=%d",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getRoles_Id(),
                user.getID());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format("DELETE FROM `users` WHERE `ID`=%d",
                user.getID());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<User> getAll(String WhereAndOrder) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WhereAndOrder + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSetUsers = statement.executeQuery(sql);
            while (resultSetUsers.next()) {
                User user = new User();
                user.setID(resultSetUsers.getLong("ID"));
                user.setLogin(resultSetUsers.getString("Login"));
                user.setPassword(resultSetUsers.getString("Password"));
                user.setEmail(resultSetUsers.getString("Email"));
                user.setRoles_Id(resultSetUsers.getLong("roles_id"));
                users.add(user);
            }
            return users;
        }
    }
}
