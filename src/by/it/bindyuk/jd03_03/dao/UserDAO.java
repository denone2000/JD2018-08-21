package by.it.bindyuk.jd03_03.dao;

import by.it.bindyuk.jd03_02.ConnectionCreator;
import by.it.bindyuk.jd03_03.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDao implements InterfaceDAO<User> {

    //==================================================================================================================
    //новый пользователь
    public boolean create(User user) throws SQLException {
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
        long id = executeCreate(sql);
        if (id > 0) {
            user.setId(id);
            return true;
        }
        return false;
    }

    //==================================================================================================================
    //прочитать пользователя из бд по id
    public User read(long id) throws SQLException {
        String where = String.format("WHERE `id`=%d", id);
        List<User> listUsers = getAll(where);
        if (listUsers.size() == 1) {
            return listUsers.get(0);
        }
        return null;
    }


    //==================================================================================================================
    //перезаписать пользователя
    public boolean update(User user) throws SQLException {
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
        return (executeUpdate(sql));
    }

    //==================================================================================================================
    //удалить пользователя
    public boolean delete(User user) throws SQLException {
        String sql = String.format("DELETE FROM `users` WHERE `id`=%d",
                user.getId());
        return (executeUpdate(sql));
    }

    //==================================================================================================================
    //Получаем список всех пользователей
    @Override
    public List<User> getAll() throws SQLException {
        List<User> result = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `users`";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("passport series"),
                        resultSet.getInt("passport id"),
                        resultSet.getString("bancard number"),
                        resultSet.getInt("cid"),
                        resultSet.getLong("roles_id"));
                result.add(user);
            }
        }
        return result;
    }

    //==================================================================================================================
    //Получаем только тех пользователей, удовлетворяющие условие(строка where в сигнатуре) для SQL запроса
    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> result = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `users` %s;", where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("passport series"),
                        resultSet.getInt("passport id"),
                        resultSet.getString("bancard number"),
                        resultSet.getInt("cid"),
                        resultSet.getLong("roles_id"));
                result.add(user);
            }
        }
        return result;
    }
}
