package by.it.bindyuk.jd03_03.dao;

import by.it.bindyuk.jd03_02.ConnectionCreator;
import by.it.bindyuk.jd03_03.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractDao implements InterfaceDAO<Role> {

    //==================================================================================================================
    //добавление роли в бд
    public boolean create(Role role) throws SQLException {
        String sql = String.format("INSERT INTO `roles`(`role`) VALUES ('%s')",
                role.getRole());
        long id = executeCreate(sql);
        if (id > 0) {
            role.setId(id);
            return true;
        }
        return false;
    }

    //==================================================================================================================
    //получить роль по id из бд
    public Role read(long id) throws SQLException {
        String where = String.format(" WHERE `id`=%d", id);
        List<Role> listRoles = getAll(where);

        if (listRoles.size() == 1) {
            return listRoles.get(0);
        }
        return null;
    }

    //==================================================================================================================
    //перезаписать роль
    public boolean update(Role role) throws SQLException {
        String sql = String.format("UPDATE `roles` SET `role`='%s' WHERE `id`=%d",
                role.getRole(),
                role.getId());
        return (executeUpdate(sql));
    }

    //==================================================================================================================
    //удалить роль
    public boolean delete(Role role) throws SQLException {
        String sql = String.format("DELETE FROM `roles` WHERE `id`=%d",
                role.getId());
        return (executeUpdate(sql));
    }

    //==================================================================================================================
    //Получаем список всех ролей
    @Override
    public List<Role> getAll() throws SQLException {
        List<Role> result = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM `roles`";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("role"));
                result.add(role);
            }
            return result;
        }
    }

    //==================================================================================================================
    //Получаем только те роли, удовлетворяющие условие(строка where в сигнатуре) для SQL запроса
    @Override
    public List<Role> getAll(String where) throws SQLException {
        List<Role> result = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = String.format("SELECT * FROM `roles` %s;", where);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("role"));
                result.add(role);
            }
            return result;
        }

    }
}
