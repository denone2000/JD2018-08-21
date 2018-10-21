package by.it.voinilo.jd03.jd03_02.CRUD;


import by.it.voinilo.jd03.jd03_02.beans.Role;
import by.it.voinilo.jd03.jd03_02.beans.RoleParam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static by.it.voinilo.jd03.jd03_02.beans.RoleParam.role;

public class UserCrub {
    public boolean create(Role role) throws SQLException {

        try (Connection connection = ConnectionCreater.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `roleparam`( `login`, `password`, `email`, `roles_id`)" +
                    " VALUES (%s,%s,%s,%d);", role.getLogin(), role.getPassword(), role.getEmail(), role.getRoles_id());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    Role.setId(id);
                    return true;
                }
            }
            return false;
        }

    }

    public boolean read(Role role) throws SQLException {
        Role result = null;
        try (Connection connection = ConnectionCreater.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT `id`, `login`, `password`, `email`, `roles_id` FROM `roleparam` WHERE 1)" + role.getId());
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                result = new Role(rs.getInt("id"),
                        rs.getString("Login"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("roles_id"));
            }

        }
        return result;

    }
//    public boolean update(Role role){
//        return false;
//    }
//    public boolean delete(Role role){
//        return false;
//    }
}
